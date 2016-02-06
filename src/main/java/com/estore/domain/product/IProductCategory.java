package com.estore.domain.product;

public interface IProductCategory {
	Long getId();
	
	String getName();
	
	String getDescription();
	
	void setName(String name);
	
	void setDescription(String description);
	
	String toString();
	
}
