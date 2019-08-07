package com.shopperstar.project.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "products", type = "product")
public class ElasticSearchProductMapping {
	
	@Id
	private String id;
	private String category;
	private String image;
	private Integer price;
	private String title;
	
	public ElasticSearchProductMapping() {}
	
	public ElasticSearchProductMapping(String id, String category, String image, Integer price, String title) {
		this.id = id;
		this.category = category;
		this.image = image;
		this.price = price;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ElasticSearchProductMapping [id=" + id + ", category=" + category + ", image=" + image + ", price="
				+ price + ", title=" + title + "]";
	}
}
