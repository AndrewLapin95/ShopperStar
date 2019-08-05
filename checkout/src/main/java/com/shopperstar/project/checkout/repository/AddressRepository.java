package com.shopperstar.project.checkout.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.checkout.model.Address;

public interface AddressRepository extends MongoRepository<Address, String> {
	
	Address save(Address cart);
	
	List<Address> findAll();
	
	Optional<Address> findById(String userId);
	
	void deleteById(String productId);
	
}
