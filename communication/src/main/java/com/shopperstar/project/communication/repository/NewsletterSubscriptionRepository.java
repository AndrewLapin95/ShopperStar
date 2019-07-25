package com.shopperstar.project.communication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.communication.model.NewsletterSubscription;

public interface NewsletterSubscriptionRepository extends MongoRepository<NewsletterSubscription, String> {
	
	NewsletterSubscription save(NewsletterSubscription subscription);
	
	List<NewsletterSubscription> findAll();
	
	Optional<NewsletterSubscription> findById(String id);
	
	void deleteById(String id);
	
}
