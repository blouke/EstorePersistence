package com.estore.domain.delivery;

public interface IDelivery {
	
	Long getId();
	
	String getName();
	
	Double getPrice();
	
	String getDescription();
	
	Long getCategoryId();
	
	String getImage();
	
	void setName(String name);
	
	void setPrice(Double price);
	
	void setDescription(String description);
	
	void setCategoryId(Long id);
	
	void setImage(String image);
	
	String toString();
}