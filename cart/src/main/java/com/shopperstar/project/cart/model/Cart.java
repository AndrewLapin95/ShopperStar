package com.shopperstar.project.cart.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cart")
public class Cart {
	
	@Id
	String userId;
	Integer productCount;
	List<ProductInCart> products;
	
	public Cart(String userId) {
		this.userId = userId;
		this.productCount = 0;
		this.products = new ArrayList<ProductInCart>();
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
	
	public List<ProductInCart> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductInCart> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", productCount=" + productCount + ", products=" + products + "]";
	}
}
