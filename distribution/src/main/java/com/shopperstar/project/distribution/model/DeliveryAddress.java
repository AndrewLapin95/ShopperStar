package com.shopperstar.project.distribution.model;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;

public class DeliveryAddress {
	
	@Id
	String userId;
	String firstName;
	String lastName;
	String company;
	String country;
	String address;
	String zipCode;
	String city;
	String province;
	
	String phoneNumber;
	
	@Email
	String email;
	
	public DeliveryAddress() {}
	
	public DeliveryAddress(String userId, String firstName, String lastName, 
				   String company, String country, String address, 
				   String zipCode, String city, String province, 
				   String phoneNumber, String email) {
		
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.country = country;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.province = province;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DeliveryAddress [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", company=" + company + ", country=" + country + ", address=" + address + ", zipCode=" + zipCode
				+ ", city=" + city + ", province=" + province + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}
}
