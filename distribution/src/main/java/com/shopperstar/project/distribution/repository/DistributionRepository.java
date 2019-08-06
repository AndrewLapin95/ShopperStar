package com.shopperstar.project.distribution.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.distribution.model.Distribution;


public interface DistributionRepository extends MongoRepository<Distribution, String>{
	
	Distribution save(Distribution distribution);
	
	List<Distribution> findAll();
	
	Optional<Distribution> findById(String userId);
	
	void deleteById(String productId);
	
}
