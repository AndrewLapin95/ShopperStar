package com.shopperstar.project.communication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopperstar.project.communication.model.Contact;
import com.shopperstar.project.communication.model.NewsletterSubscription;

public interface ContactRepository extends MongoRepository<Contact, String>{
	
	Contact save(Contact contact);
	
	List<Contact> findAll();
	
	Optional<Contact> findById(String id);
	
	void deleteById(String id);
}
