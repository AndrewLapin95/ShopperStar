package com.shopperstar.project.products.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.products.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	Product save(Product subscription);
	
	List<Product> findAll();
	
	Optional<Product> findById(String id);
	
	void deleteById(String id);
	
}
