package com.shopperstar.project.cart.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopperstar.project.cart.model.Cart;
import com.shopperstar.project.cart.model.ProductInCart;
import com.shopperstar.project.cart.model.ProductToDelete;
import com.shopperstar.project.cart.repository.CartRepository;

@RestController
public class CartController {
	
	@Autowired
	private CartRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(CartRepository.class);
	
	@PostMapping("/api/create-cart/{userId}")
	public String createCart(@PathVariable String userId) {
		
		if (getCart(userId).isPresent()) {
			
			logger.info("Cart for user: " + userId + " already exists");
			return userId;
			
		} else {
			
			try {
				
				logger.info("Creating new cart for user: " + userId);
				Cart cart = new Cart(userId);
				repository.save(cart);
				return cart.getUserId();
					
			} catch (Exception e) {
					
				logger.error("Failed to create new cart for: " + userId);
				logger.error(e.toString());
				return null;
			}
			
		}
	}
	
	@GetMapping("/api/get-cart/{userId}")
	public Optional<Cart> getCart(@PathVariable String userId) {
		return repository.findById(userId);
	}
	
	@PostMapping("/api/add-item/{userId}")
	public ProductInCart addItemToCart(@PathVariable("userId") String userId, @Valid @RequestBody ProductInCart updatedProduct) {
		
		Cart cart = findCartByUserId(userId);
		
		ProductInCart product = cart.getProductById(updatedProduct.getProductId());
		cart.setProductCount(cart.getProductCount() + updatedProduct.getCount());
		
		if (product != null) {
			
			logger.info("Adding additional product to cart...");
			product.setCount(product.getCount() + updatedProduct.getCount());
			
		} else {
			
			logger.info("Creating new product in the cart...");
			product = new ProductInCart(updatedProduct.getProductId(), updatedProduct.getCount());
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
		
		int removedProductCount = cart.removeProductById(productToDelete.getProductId());
		
		if (removedProductCount == 0) {
			logger.warn("Item: " + productToDelete.getProductId() + " was not found in the cart...");
			return false;
		}
		
		cart.setProductCount(cart.getProductCount() - removedProductCount);
		
		repository.save(cart);
		
		return true;
	}
	
	@DeleteMapping("/api/delete-items/{userId}")
	public boolean deleteAllItemsInCart(@PathVariable String userId) {
		
		Cart cart = findCartByUserId(userId);
		
		if (cart == null) {
			return false;
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
			return null;
			
		}
		
		logger.info("Located cart for user: " + optionalCart.get().getUserId());
		
		return optionalCart.get();
	}
}
