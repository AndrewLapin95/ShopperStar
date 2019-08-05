package com.shopperstar.project.cart.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shopperstar.project.cart.resource.DeliveryMethod;

@Document(collection = "Cart")
public class Cart {
	
	@Id
	String userId;
	
	Integer productCount;
	Double totalPrice;
	DeliveryMethod deliveryMethod;
	List<ProductInCart> products;
	
	public Cart(String userId) {
		this.userId = userId;
		this.productCount = 0;
		this.products = new ArrayList<ProductInCart>();
		this.deliveryMethod = DeliveryMethod.STANDARD_DELIVERY;
		this.totalPrice = DeliveryMethod.getDeliveryPrice(this.deliveryMethod);
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
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		
		this.setTotalPrice(this.getTotalPrice() - DeliveryMethod.getDeliveryPrice(this.deliveryMethod));
		this.deliveryMethod = deliveryMethod;
		this.setTotalPrice(this.getTotalPrice() + DeliveryMethod.getDeliveryPrice(this.deliveryMethod));
		
	}
	
	public ProductInCart getProductById(String productId) {
		
		for (ProductInCart product : this.products) {
			if (product.getProductId().equals(productId)) {
				return product;
			}
			
		}
		
		return null;
	}
	
	public int removeProductById(String productId) {
		
		for (ProductInCart product : this.products) {
			
			if (product.getProductId().equals(productId)) {
				int productCount = product.getCount();
				this.products.remove(product);
				return productCount;
			}
			
		}
		
		return 0;
	}
	
	public void removeAllItems() {
		
		while(this.products.size() > 0) {
			this.products.remove(0);
		}
		
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", productCount=" + productCount + ", totalPrice=" + totalPrice
				+ ", deliveryMethod=" + deliveryMethod + ", products=" + products + "]";
	}
}
