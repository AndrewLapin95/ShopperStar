package com.shopperstar.project.communication.entity;

public class Contact {
	
	private String userId;
	private String email;
	
	public String getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [userId=" + userId + ", email=" + email + "]";
	}
	
}
