package com.shopperstar.project.checkout.model;

public class OrderDetailsProduct {
	
	String productTitle;
	Integer productPrice;
	
	public OrderDetailsProduct(String productTitle, Integer productPrice) {
		this.productTitle = productTitle;
		this.productPrice = productPrice;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "OrderDetailsProduct [productTitle=" + productTitle + ", productPrice=" + productPrice + "]";
	}
	
}
