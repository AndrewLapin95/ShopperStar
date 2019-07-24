package com.shopperstar.project.communication.controller;

import java.util.List;

import com.shopperstar.project.communication.repository.NewsletterSubscriptionDTO;

public interface NewsletterSubscriptionService {
	
	public NewsletterSubscriptionDTO create(NewsletterSubscriptionDTO newsletterSubscriptionDTO);
	
	public NewsletterSubscriptionDTO delete(String id);
	
	public List<NewsletterSubscriptionDTO> findAll();
	
	public NewsletterSubscriptionDTO findById(String id);
	
	public NewsletterSubscriptionDTO update(NewsletterSubscriptionDTO newsletterSubscription);
}
