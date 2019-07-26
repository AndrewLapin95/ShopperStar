package com.shopperstar.project.communication.resource;

import java.util.List;
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

import com.shopperstar.project.communication.model.NewsletterSubscription;
import com.shopperstar.project.communication.repository.NewsletterSubscriptionRepository;

@RestController
public class NewsletterSubscriptionController {

	@Autowired
	private NewsletterSubscriptionRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(NewsletterSubscriptionController.class);
	
	@PostMapping("/api/subscribe")
	public String saveNewsletterSubscription(@Valid @RequestBody NewsletterSubscription subscription) {
		
		List<NewsletterSubscription> subscriptions = repository.findAll();
		
		for (NewsletterSubscription sub : subscriptions) {
			if (sub.getEmail().equals(subscription.getEmail())) {
				logger.info("Subscription for the email " + sub.getEmail() + " already exists!");
				return subscription.getEmail();
			}
		}
		
		try {
			
			logger.info("Adding new subscription: " + subscription.getEmail());
			repository.save(subscription);
			logger.info("Successfully added new subscription: " + subscription.getEmail());
			
		} catch (Exception ex) {
			
			logger.error("Failed to save subscription: " + subscription.getEmail());
			logger.error(ex.getMessage());
			
		}
		
		return subscription.getEmail();
	}
	
	@GetMapping("/api/get-newsletter-subscriptions")
	public List<NewsletterSubscription> getNewsletterSubscriptions() {
		return repository.findAll();
	}
	
	@GetMapping("/api/get-newsletter-subscription/{id}")
	public Optional<NewsletterSubscription> getNewsletterSubscription(@PathVariable String id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/api/unsubscribe/{id}")
	public String deleteNewsletterSubscription(@PathVariable String id) {
		
		try {
			
			logger.info("Attempting to delete subscription: " + id);
			repository.deleteById(id);
			
			
		} catch (Exception ex) {
			logger.error("Failed to delete subscription: " + id);
			logger.error(ex.getMessage());
		}
		
		return id;
	}
	
}
