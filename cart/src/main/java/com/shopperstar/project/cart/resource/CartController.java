package com.shopperstar.project.cart.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopperstar.project.cart.model.Cart;
import com.shopperstar.project.cart.model.ProductInCart;
import com.shopperstar.project.cart.repository.CartRepository;

@RestController
public class CartController {
	
	private CartRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(CartRepository.class);
	
	public String saveCart(@Valid @RequestBody Cart cart) {
		
		Optional<Cart> savedCart = getCart(cart.getUserId());
		
		if (savedCart != null) {
			
			logger.info("Cart for user: " + cart.getUserId() + " already exists.");
			return savedCart.get().getUserId();
			
		} else {
			
			try {
				
				logger.info("Creating new cart for user: " + cart.getUserId());
				repository.save(cart);
				return cart.getUserId();
				
			} catch (Exception e) {
				
				logger.error("Failed to create new cart for: " + cart.getUserId());
				logger.error(e.toString());
				return null;
			}
			
		}
		
	}
	
	public Optional<Cart> getCart(String userId) {
		return repository.findById(userId);
	}
	
	public ProductInCart addItemToCart(String userId, String productId, Integer count) {
		
		Optional<Cart> optionalCart = getCart(userId);
		
		if (optionalCart == null) {
			logger.error("Cart for user: " + userId + " does not exist.");
			return null;
		}
		
		Cart cart = optionalCart.get();
		ProductInCart newProduct = new ProductInCart(productId, count);
		
		cart.getProducts().add(newProduct);
		
		return newProduct;
	}

	public ProductInCart updateProductCount(String userId, String productId, Integer newCount) {
		
		Optional<Cart> optionalCart = getCart(userId);
		
		if (optionalCart == null) {
			logger.error("Cart for user: " + userId + " does not exist.");
			return null;
		}
		
		Cart cart = optionalCart.get();
		cart.getProductById(productId).setCount(newCount);
		
		return cart.getProductById(productId);
	}
}
