package com.shopperstar.project.communication.entity;

import javax.persistence.Id;


public class NewsletterSubscription {
	
	@Id
	private String newsletterSubscriptionId;
	
	private String email;
	
	public NewsletterSubscription(String newsletterSubscriptionId, String email) {
		this.newsletterSubscriptionId = newsletterSubscriptionId;
		this.email = email;
	}

	public String getNewsletterSubscriptionId() {
		return newsletterSubscriptionId;
	}
	
	public void setNewsletterSubscriptionId(String newsletterSubscriptionId) {
		this.newsletterSubscriptionId = newsletterSubscriptionId;
	}

	public String getNewsletterSubscriptionEmail() {
		return email;
	}
	
	public void setNewsletterSubscriptionEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [newsletterSubscriptionId=" + newsletterSubscriptionId + ", email=" + email + "]";
	}
	
}
