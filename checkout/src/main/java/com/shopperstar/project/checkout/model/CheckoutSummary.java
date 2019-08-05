package com.shopperstar.project.checkout.model;

import java.util.List;

public class CheckoutSummary {
	
	List<OrderDetailsProduct> products;
	Integer subtotal;
	Integer shippingPrice;
	Integer totalPrice;
	PaymentMethod method;
	
	public CheckoutSummary(List<OrderDetailsProduct> products, Integer subtotal, 
						   Integer shippingPrice, Integer totalPrice, PaymentMethod method) {
		
		this.products = products;
		this.subtotal = subtotal;
		this.shippingPrice = shippingPrice;
		this.totalPrice = totalPrice;
		this.method = method;
	}
	
	public List<OrderDetailsProduct> getProducts() {
		return products;
	}
	
	public void setProducts(List<OrderDetailsProduct> products) {
		this.products = products;
	}
	
	public Integer getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	
	public Integer getShippingPrice() {
		return shippingPrice;
	}
	
	public void setShippingPrice(Integer shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	
	public Integer getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public PaymentMethod getMethod() {
		return method;
	}
	
	public void setMethod(PaymentMethod method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "CheckoutSummary [products=" + products + ", subtotal=" + subtotal + ", shippingPrice=" + shippingPrice
				+ ", totalPrice=" + totalPrice + ", method=" + method + "]";
	}
	
}
