package com.shopperstar.project.communication.entity;

import org.springframework.data.annotation.Id;


public class NewsletterSubscription {
	
	@Id
	String subscriptionId;
	
	String firstName;
	String lastName;
	String subject;
	String message;
	
	public NewsletterSubscription(String userId, String firstName, String lastName, String subject, String message) {
		super();
		this.subscriptionId = subscriptionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
		this.message = message;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}
	
	public void setSubscriptionId(String userId) {
		this.subscriptionId = userId;
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
		return "NewsletterSubscription [userId=" + subscriptionId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", subject=" + subject + ", message=" + message + "]";
	}
}
