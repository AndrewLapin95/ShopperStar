package com.shopperstar.project.distribution.model;

import org.springframework.data.annotation.Id;

public class OrderSummaryProduct {
	
	@Id
	String productId;
	String productTitle;
	Integer count;
	Integer productPrice;
	
	public OrderSummaryProduct() {}
	
	public OrderSummaryProduct(String productId, String productTitle, Integer count, Integer productPrice) {
		this.productId = productId;
		this.productTitle = productTitle;
		this.count = count;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "OrderSummaryProduct [productId=" + productId + ", productTitle=" + productTitle + ", count=" + count
				+ ", productPrice=" + productPrice + "]";
	}
}
