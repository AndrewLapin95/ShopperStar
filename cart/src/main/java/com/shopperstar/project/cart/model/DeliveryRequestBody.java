package com.shopperstar.project.cart.model;

public class DeliveryRequestBody {
	
	String deliveryMethod;

	public DeliveryRequestBody() {}
	
	public DeliveryRequestBody(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	@Override
	public String toString() {
		return "DeliveryRequestBody [deliveryMethod=" + deliveryMethod + "]";
	}
}
