package com.shopperstar.project.products.model;

public class ImageUri {
	
	String imageUri;
	
	public ImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	@Override
	public String toString() {
		return "ImageUri [imageUri=" + imageUri + "]";
	}
	
}
