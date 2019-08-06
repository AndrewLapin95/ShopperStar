package com.shopperstar.project.distribution.model;

import java.util.List;


public class OrderSummary {
	
	String userId;
	Integer productCount;
	Double totalPrice;
	String deliveryMethod;
	List<OrderSummaryProduct> products;
	
	public OrderSummary() {}
	
	public OrderSummary(String userId, Integer productCount, Double totalPrice, 
					    String deliveryMethod, List<OrderSummaryProduct> products) {
		
		this.userId = userId;
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.deliveryMethod = deliveryMethod;
		this.products = products;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public List<OrderSummaryProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderSummaryProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderSummary [userId=" + userId + ", productCount=" + productCount + ", totalPrice=" + totalPrice
				+ ", deliveryMethod=" + deliveryMethod + ", products=" + products + "]";
	}
}
