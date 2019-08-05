package com.shopperstar.project.checkout.model;

import org.springframework.data.annotation.Id;

public class OrderDetails {
	
	@Id
	String userId;
	Address address;
	CheckoutSummary checkoutSummary;
	
	public OrderDetails(String userId, Address address, CheckoutSummary checkoutSummary) {
		this.userId = userId;
		this.address = address;
		this.checkoutSummary = checkoutSummary;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAdress(Address adress) {
		this.address = adress;
	}
	
	public CheckoutSummary getCheckoutSummary() {
		return checkoutSummary;
	}
	
	public void setCheckoutSummary(CheckoutSummary checkoutSummary) {
		this.checkoutSummary = checkoutSummary;
	}

	@Override
	public String toString() {
		return "OrderDetails [userId=" + userId + ", address=" + address + ", checkoutSummary=" + checkoutSummary + "]";
	}
}
