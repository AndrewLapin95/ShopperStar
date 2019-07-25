package com.shopperstar.project.communication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.communication.model.NewsletterSubscription;

public interface NewsletterSubscriptionRepository extends MongoRepository<NewsletterSubscription, String> {

	
}
