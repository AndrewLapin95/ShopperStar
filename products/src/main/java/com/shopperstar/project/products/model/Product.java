package com.shopperstar.project.products.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

enum Category {
	PHONES,
	LAPTOPS,
	CAMERAS,
	HEADPHONES
}

enum Availability {
	IN_STOCK,
	UNAVAILABLE
}

@Document(collection = "Products")
public class Product {
	
	@Id
	private String id;
	private String title;
	private Integer oldPrice;
	private Integer newPrice;
	private Category category;
	private Availability availability;
	private List<ImageUri> images;
	private String description;
	
	public Product() {}
	
	public Product(String id, String title, 
				   Integer oldPrice, Integer newPrice, 
				   Category category, Availability availability, 
				   String description) {
		
		this.id = id;
		this.title = title;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.category = category;
		this.availability = availability;
		this.description = description;
		this.images = new ArrayList<ImageUri>();
		
	}
	
	public Product(String title, 
			   Integer oldPrice, Integer newPrice, 
			   Category category, Availability availability, 
			   String description) {
	
	this.title = title;
	this.oldPrice = oldPrice;
	this.newPrice = newPrice;
	this.category = category;
	this.availability = availability;
	this.description = description;
	this.images = new ArrayList<ImageUri>();
	
}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getOldPrice() {
		return oldPrice;
	}
	
	public void setOldPrice(Integer oldPrice) {
		this.oldPrice = oldPrice;
	}
	
	public Integer getNewPrice() {
		return newPrice;
	}
	
	public void setNewPrice(Integer newPrice) {
		this.newPrice = newPrice;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Availability getAvailability() {
		return availability;
	}
	
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	
	public List<ImageUri> getImages() {
		return images;
	}
	
	public void setImages(List<ImageUri> images) {
		this.images = images;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice
				+ ", category=" + category + ", availability=" + availability + ", images=" + images + ", description="
				+ description + "]";
	}
	
}
