package com.shopperstar.project.communication.service;

import javax.persistence.EntityManager;

import com.shopperstar.project.communication.entity.Contact;

public class ContactDAOService {
	
	private EntityManager entityManager;
	
	public String insert(Contact contact) {
		entityManager.persist(contact);
		return contact.getUserId();
	}
}
