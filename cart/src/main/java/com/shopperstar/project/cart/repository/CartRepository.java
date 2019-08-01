package com.shopperstar.project.cart.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.cart.model.Cart;

public interface CartRepository extends MongoRepository<Cart, String>{

	Cart save(Cart cart);
	
	Optional<Cart> findById(String userId);
	
	void deleteById(String productId);
	
}
