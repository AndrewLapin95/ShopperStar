package com.shopperstar.project.communication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.shopperstar.project.communication.entity.Contact;

interface ContactRepository extends Repository<Contact, String> {
	
	void delete(Contact deleted);
	
	List<Contact> findAll();
	
	Optional<Contact> findOne(String id);
	
	Contact save(Contact saved);
}
