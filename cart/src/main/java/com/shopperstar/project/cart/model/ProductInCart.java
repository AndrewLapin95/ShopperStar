package com.shopperstar.project.cart.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductInCart {
	
	@NotNull
	String productId;
	String productTitle;
	Integer count;
	Integer productPrice;
	
	public ProductInCart(String productId, String productTitle, Integer count, Integer productPrice) {
		this.productId = productId;
		this.productTitle = productTitle;
		this.count = count;
		this.productPrice = productPrice;
	}
	
	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
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

	@Override
	public String toString() {
		return "ProductInCart [productId=" + productId + ", productTitle=" + productTitle + ", count=" + count
				+ ", productPrice=" + productPrice + "]";
	}
	
}
