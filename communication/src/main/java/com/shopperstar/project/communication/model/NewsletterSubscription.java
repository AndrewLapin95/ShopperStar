package com.shopperstar.project.communication.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NewsletterSubscriptions")
public class NewsletterSubscription {
	
	private int id;
	
	private String email;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "NewsletterSubscription [id=" + id + ", email=" + email + "]";
	}
	
}
