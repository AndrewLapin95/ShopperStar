package com.shopperstar.project.communication.repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class NewsletterSubscriptionDTO {
	
	private String id;
	
	@NotEmpty
	@Email
	private String email;

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
}
