package com.shopperstar.project.communication.repository;

import java.util.List;

import com.shopperstar.project.communication.controller.NewsletterSubscriptionDTO;

interface NewsletterSubscriptionInterface {
	
	NewsletterSubscriptionDTO create(NewsletterSubscriptionDTO contact);
	
	NewsletterSubscriptionDTO delete(String id);
	
	List<NewsletterSubscriptionDTO> findAll();
	
	NewsletterSubscriptionDTO findById(String id);
	
	NewsletterSubscriptionDTO update(NewsletterSubscriptionDTO contact);
}
