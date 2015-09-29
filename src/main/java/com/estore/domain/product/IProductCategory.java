package com.estore.domain.product;

public interface IProductCategory {
	Long getId();
	
	String getName();
	
	String getTags();
	
	void setName(String name);
	
	void setTags(String tags);
	
	String toString();
	
}
