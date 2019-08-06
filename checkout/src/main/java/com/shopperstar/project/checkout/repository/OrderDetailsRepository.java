package com.shopperstar.project.checkout.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.checkout.model.OrderDetails;

public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String> {
	
	OrderDetails save(OrderDetails orderDetails);
	
	List<OrderDetails> findAll();
	
	Optional<OrderDetails> findById(String userId);
	
	void deleteById(String userId);
}
