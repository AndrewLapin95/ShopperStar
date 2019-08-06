package com.shopperstar.project.cart.resource;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shopperstar.project.cart.model.Cart;
import com.shopperstar.project.cart.model.DeliveryRequestBody;
import com.shopperstar.project.cart.model.ProductInCart;
import com.shopperstar.project.cart.model.ProductToDelete;
import com.shopperstar.project.cart.repository.CartRepository;

@RestController
public class CartController {
	
	@Autowired
	private CartRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@PostMapping("/api/create-cart/{userId}")
	public ResponseEntity<Cart> createCart(@PathVariable String userId) {
		
		Cart savedCart = null;
		
		if (getCart(userId).isPresent()) {
			
			logger.info("Cart for user: " + userId + " already exists");
			savedCart = getCart(userId).get();
			
		} else {
			
			try {
				
				logger.info("Creating new cart for user: " + userId);
				Cart cart = new Cart(userId);
				savedCart = repository.save(cart);
					
			} catch (Exception e) {
					
				logger.error("Failed to create new cart for: " + userId);
				logger.error(e.toString());
				return null;
			}
			
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .buildAndExpand(savedCart.getUserId())
												  .toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/api/get-cart/{userId}")
	public Optional<Cart> getCart(@PathVariable String userId) {
		return repository.findById(userId);
	}
	
	@PostMapping("/api/update-delivery-method/{userId}")
	public Cart updateDeliveryMethod(@PathVariable("userId") String userId, @Valid @RequestBody DeliveryRequestBody method) {
		
		Cart cart = findCartByUserId(userId);
		
		cart.setDeliveryMethod(method.getDeliveryMethod());
		
		try {
			
			logger.info("Attempting to save delivery method for cart: " + cart.getUserId());
			repository.save(cart);
			logger.info("Successfully saved delivery method for cart: " + cart.getUserId());
			
		} catch (Exception e) {
			
			logger.error("Failed to save delivery method for cart: " + cart.getUserId());
			logger.error(e.toString());
			
		}
		
		return cart;
	}
	
	@PostMapping("/api/add-item/{userId}")
	public ProductInCart addItemToCart(@PathVariable("userId") String userId, @Valid @RequestBody ProductInCart updatedProduct) {
		
		Cart cart = findCartByUserId(userId);
		
		ProductInCart product = cart.getProductById(updatedProduct.getProductId());
		cart.setTotalPrice(cart.getTotalPrice() + updatedProduct.getProductPrice() * updatedProduct.getCount());
		cart.setProductCount(cart.getProductCount() + updatedProduct.getCount());
		
		if (product != null) {
			
			logger.info("Adding additional product to cart...");
			product.setCount(product.getCount() + updatedProduct.getCount());
			
		} else {
			
			logger.info("Creating new product in the cart...");
			
			product = new ProductInCart(updatedProduct.getProductId(), 
										updatedProduct.getProductTitle(), 
										updatedProduct.getCount(), 
										updatedProduct.getProductPrice());
			
			cart.getProducts().add(product);
			
		}
		
		try {
			
			logger.info("Attempting to save: " + updatedProduct.toString());
			repository.save(cart);
			logger.info("Successfully saved: " + updatedProduct.getProductId());
			
		} catch (Exception e) {
			
			logger.error("Failed to save: " + updatedProduct.toString());
			logger.error(e.toString());
			
		}
		
		return product;
	}

	@DeleteMapping("/api/delete-item/{userId}")
	public boolean deleteItemInCart(@PathVariable String userId, @Valid @RequestBody ProductToDelete productToDelete) {
		
		Cart cart = findCartByUserId(userId);
		
		if (cart == null) {
			return false;
		}
		
		Integer removedProductPrice = cart.getProductById(productToDelete.getProductId()).getProductPrice();
		Integer removedProductCount = cart.removeProductById(productToDelete.getProductId());
		
		if (removedProductCount == 0) {
			logger.warn("Item: " + productToDelete.getProductId() + " was not found in the cart...");
			return false;
		}
		
		cart.setTotalPrice(cart.getTotalPrice() - removedProductPrice * removedProductCount);
		cart.setProductCount(cart.getProductCount() - removedProductCount);
		
		repository.save(cart);
		
		return true;
	}
	
	@DeleteMapping("/api/delete-items/{userId}")
	public boolean deleteAllItemsInCart(@PathVariable String userId) {
		
		Cart cart = findCartByUserId(userId);
		
		if (cart == null) {
			throw new CartNotFoundException("UserId: " + userId);
		}
		
		cart.removeAllItems();
		cart.setProductCount(0);
		repository.save(cart);
		
		return true;
		
	}
	
	public Cart findCartByUserId(String userId) {
		
		Optional<Cart> optionalCart = repository.findById(userId);
		
		if (optionalCart.get() == null) {
			
			logger.error("Cart for user: " + userId + " does not exist.");
			throw new CartNotFoundException("UserId: " + userId);
			
		}
		
		logger.info("Located cart for user: " + optionalCart.get().getUserId());
		
		return optionalCart.get();
	}
}
