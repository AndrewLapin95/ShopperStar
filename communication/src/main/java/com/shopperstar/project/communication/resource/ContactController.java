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

import com.shopperstar.project.communication.model.Contact;
import com.shopperstar.project.communication.repository.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	private ContactRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@PostMapping("/api/save-contact")
	public String saveContact(@Valid @RequestBody Contact contact) {
		
		try {
			
			logger.info("Adding new contact request: " + contact.getId());
			repository.save(contact);
			logger.info("Successfully added new subscription: " + contact.getId());
			
		} catch (Exception ex) {
			
			logger.error("Failed to save contact request: " + contact.getId());
			logger.error(ex.getMessage());
			
		}
		
		return contact.getId();
	}
	
	@GetMapping("/api/get-contact-requests")
	public List<Contact> getContacts() {
		return repository.findAll();
	}
	
	@GetMapping("/api/get-contact-request/{id}")
	public Optional<Contact> getContact(@PathVariable String id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/api/remove-contact-request/{id}")
	public String deleteNewsletterSubscription(@PathVariable String id) {
		
		try {
			
			logger.info("Attempting to delete contact request: " + id);
			repository.deleteById(id);
			
			
		} catch (Exception ex) {
			
			logger.error("Failed to delete contact request: " + id);
			logger.error(ex.getMessage());
			
		}
		
		return id;
	}
}
