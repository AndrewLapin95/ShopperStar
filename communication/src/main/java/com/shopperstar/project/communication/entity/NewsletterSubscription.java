package com.shopperstar.project.communication.entity;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;


public class NewsletterSubscription {
	
	@Id
	String userId;
	
	String firstName;
	String lastName;
	String subject;
	String message;
	
	public NewsletterSubscription(String userId, String firstName, String lastName, String subject, String message) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
		this.message = message;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NewsletterSubscription [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subject=" + subject + ", message=" + message + "]";
	}
}
