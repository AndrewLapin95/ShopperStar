package com.shopperstar.project.communication.resource;

import java.util.List;
import java.util.Optional;

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
	
	@PostMapping("/api/subscribe")
	public String saveNewsletterSubscription(@RequestBody NewsletterSubscription subscription) {
		repository.save(subscription);
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
		repository.deleteById(id);
		return id;
	}
	
}
