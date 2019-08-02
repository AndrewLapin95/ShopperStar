package com.shopperstar.project.cart.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductInCart {
	
	@NotNull
	String productId;
	Integer count;
	
	public ProductInCart(String productId, Integer count) {
		this.productId = productId;
		this.count = count;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "ProductInCart [productId=" + productId + ", count=" + count + "]";
	}
	
}
