package com.shopperstar.project.communication.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopperstar.project.communication.controller.NewsletterSubscriptionService;
import com.shopperstar.project.communication.entity.NewsletterSubscription;

@Service
public class MongoDBNewsletterSubscriptionService implements NewsletterSubscriptionService {

	private final NewsletterSubscriptionRepository repository;
	
	@Autowired
	public MongoDBNewsletterSubscriptionService(NewsletterSubscriptionRepository repository) {
		this.repository = repository;
	}

	@Override
	public NewsletterSubscriptionDTO create(NewsletterSubscriptionDTO newsletterSubscription) {
		NewsletterSubscription newContact = new NewsletterSubscription(newsletterSubscription.getEmail());
		newContact = repository.save(newContact);
		return convertToDTO(newContact);
	}

	@Override
	public NewsletterSubscriptionDTO delete(String id) {
		NewsletterSubscription deleted = findNewsletterSubscriptionById(id);
		repository.delete(deleted);
		return convertToDTO(deleted);
	}

	@Override
	public List<NewsletterSubscriptionDTO> findAll() {
		List<NewsletterSubscription> contacts = repository.findAll();
		return convertToDTOs(contacts);
	}

	@Override
	public NewsletterSubscriptionDTO findById(String id) {
		NewsletterSubscription newsletterSubscription = findNewsletterSubscriptionById(id);
		return convertToDTO(newsletterSubscription);
	}

	@Override
	public NewsletterSubscriptionDTO update(NewsletterSubscriptionDTO newsletterSubscription) {
		NewsletterSubscription newsletterSubscriptionToUpdate = findNewsletterSubscriptionById(newsletterSubscription.getId());
		newsletterSubscriptionToUpdate.setNewsletterSubscriptionEmail(newsletterSubscription.getEmail());
		newsletterSubscriptionToUpdate = repository.save(newsletterSubscriptionToUpdate);
		return convertToDTO(newsletterSubscriptionToUpdate);
		
	}
	
	private NewsletterSubscription findNewsletterSubscriptionById(String id) {
		Optional<NewsletterSubscription> foundContact = repository.findOne(id);
		return foundContact.get();
	}
	
	private List<NewsletterSubscriptionDTO> convertToDTOs(List<NewsletterSubscription> contacts) {
		
		List<NewsletterSubscriptionDTO> dtos = new ArrayList<NewsletterSubscriptionDTO>();
		
		for (NewsletterSubscription contact : contacts) {
			dtos.add(convertToDTO(contact));
		}
		
		return dtos;
	}
	
	private NewsletterSubscriptionDTO convertToDTO(NewsletterSubscription newsletterSubscription) {
		NewsletterSubscriptionDTO dto = new NewsletterSubscriptionDTO();
		
		dto.setId(newsletterSubscription.getNewsletterSubscriptionId());
		dto.setEmail(newsletterSubscription.getNewsletterSubscriptionEmail());
		
		return dto;
	}
	
}
