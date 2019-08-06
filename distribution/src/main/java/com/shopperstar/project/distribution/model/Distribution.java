package com.shopperstar.project.distribution.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Distribution")
public class Distribution {
	
	@Id
	String userId;
	DeliveryAddress address;
	OrderSummary summary;
	
	public Distribution() {}
	
	public Distribution(String userId, DeliveryAddress address, OrderSummary summary) {
		this.userId = userId;
		this.address = address;
		this.summary = summary;
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

	public OrderSummary getSummary() {
		return summary;
	}

	public void setSummary(OrderSummary summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Distribution [userId=" + userId + ", address=" + address + ", summary=" + summary + "]";
	}
}
