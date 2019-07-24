package com.shopperstar.project.communication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.shopperstar.project.communication.entity.NewsletterSubscription;

interface NewsletterSubscriptionRepository extends Repository<NewsletterSubscription, String> {
	
	void delete(NewsletterSubscription deleted);
	
	List<NewsletterSubscription> findAll();
	
	Optional<NewsletterSubscription> findOne(String id);
	
	NewsletterSubscription save(NewsletterSubscription saved);
}
