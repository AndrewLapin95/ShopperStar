package com.shopperstar.project.communication.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopperstar.project.communication.controller.ContactDTO;

@Service
public class MongoDBContactService implements ContactServiceInterface {

	private final ContactRepository repository;
	
	@Autowired
	public MongoDBContactService(ContactRepository repository) {
		this.repository = repository;
	}

	@Override
	public ContactDTO create(ContactDTO contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactDTO delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactDTO update(ContactDTO contact) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
