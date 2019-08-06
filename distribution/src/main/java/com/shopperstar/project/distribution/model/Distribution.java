package com.shopperstar.project.distribution.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Distribution")
public class Distribution {
	
	@Id
	String userId;
	DeliveryAddress address;
	OrderSummary checkoutSummary;
	
	public Distribution() {}
	
	public Distribution(String userId, DeliveryAddress address, OrderSummary checkoutSummary) {
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

	public DeliveryAddress getAddress() {
		return address;
	}

	public void setAddress(DeliveryAddress address) {
		this.address = address;
	}

	public OrderSummary getCheckoutSummary() {
		return checkoutSummary;
	}

	public void setCheckoutSummary(OrderSummary checkoutSummary) {
		this.checkoutSummary = checkoutSummary;
	}

	@Override
	public String toString() {
		return "Distribution [userId=" + userId + ", address=" + address + ", checkoutSummary=" + checkoutSummary + "]";
	}
}
