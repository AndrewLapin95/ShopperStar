package com.shopperstar.project.communication.repository;

import java.util.List;

import com.shopperstar.project.communication.controller.ContactDTO;

interface ContactServiceInterface {
	
	ContactDTO create(ContactDTO contact);
	
	ContactDTO delete(String id);
	
	List<ContactDTO> findAll();
	
	ContactDTO findById(String id);
	
	ContactDTO update(ContactDTO contact);
}
