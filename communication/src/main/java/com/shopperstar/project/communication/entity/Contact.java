package com.shopperstar.project.communication.entity;

import javax.persistence.Id;

public class Contact {
	
	@Id
	private String contactId;
	
	private String email;
	
	public Contact(String userId, String email) {
		super();
		this.contactId = userId;
		this.email = email;
	}

	public String getContactId() {
		return contactId;
	}

	public String getEmail() {
		return email;
	}

	public void setContactId(String userId) {
		this.contactId = userId;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [userId=" + contactId + ", email=" + email + "]";
	}
	
}
