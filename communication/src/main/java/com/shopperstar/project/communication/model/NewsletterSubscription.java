package com.shopperstar.project.communication.model;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NewsletterSubscriptions")
public class NewsletterSubscription {
	
	@Id
	private String id;
	
	@Email
	private String email;
	
	public NewsletterSubscription() {}
	
	public NewsletterSubscription(String id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public NewsletterSubscription(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
