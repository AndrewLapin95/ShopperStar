package com.shopperstar.project.cart.model;

public class ProductToDelete {
	
	String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductToDelete [productId=" + productId + "]";
	}
	
	
}
