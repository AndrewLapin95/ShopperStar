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
import com.shopperstar.project.cart.repository.CartRepository;

@RestController
public class CartController {
	
	@Autowired
	private CartRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(CartRepository.class);
	
	@PostMapping("/api/create-cart")
	public String createCart(@Valid @RequestBody String userId) {
		
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
	
	@GetMapping("/api/get-cart")
	public Optional<Cart> getCart(@Valid @RequestBody String userId) {
		return repository.findById(userId);
	}
	
	@PostMapping("/api/add-item/{productId}/{count}")
	public ProductInCart addItemToCart(@Valid @RequestBody String userId, 
									   @PathVariable("productId") String productId, 
									   @PathVariable("count") Integer count) {
		
		Optional<Cart> optionalCart = repository.findById(userId);
		
		if (optionalCart.get() == null) {
			
			logger.error("Cart for user: " + userId + " does not exist.");
			return null;
			
		}
		
		Cart cart = optionalCart.get();
		logger.info("Located cart for user: " + cart.getUserId());
		ProductInCart product = cart.getProductById(productId);
		
		if (product != null) {
			
			logger.info("Adding additional product to cart...");
			
			product = cart.getProductById(productId);
			product.setCount(product.getCount() + 1);
			
		} else {
			
			logger.info("Creating new product in the cart...");
			product = new ProductInCart(productId, count);
			
		}
		
		cart.getProducts().add(product);
		cart.setProductCount(cart.getProductCount() + count);
		
		try {
			
			logger.info("Attempting to save: " + product.toString());
			repository.save(cart);
			logger.info("Successfully saved: " + product.getProductId());
			
		} catch (Exception e) {
			
			logger.error("Failed to save: " + product.toString());
			logger.error(e.toString());
			
		}
		
		return product;
	}

	@DeleteMapping("/api/delete-item")
	public boolean deleteItemInCart(@Valid @RequestBody String userId, @Valid @RequestBody String productId) {
		
		Optional<Cart> optionalCart = getCart(userId);
		
		if (optionalCart.get() == null) {
			
			logger.error("Cart for user: " + userId + " does not exist.");
			return false;
			
		}
		
		Cart cart = optionalCart.get();
	
		if (!cart.removeProductById(productId)) {
			logger.error("Failed to remove item: " + productId);
			return false;
		}
		
		repository.save(cart);
		
		return true;
	}
}
