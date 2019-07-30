package com.shopperstar.project.communication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ContactRequests")
public class Contact {
	
	@Id
	String id;
	String firstName;
	String lastName;
	String subject;
	String message;
	
	public Contact() {}
	
	public Contact(String id, String firstName, String lastName, String subject, String message) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
		
		if (subject != null) {
			this.subject = subject;
		} else {
			this.subject = "";
		}
	}
	
	public Contact(String firstName, String lastName, String subject, String message) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
		
		if (subject != null) {
			this.subject = subject;
		} else {
			this.subject = "";
		}
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject
				+ ", message=" + message + "]";
	}
	
}
