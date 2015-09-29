package com.estore.domain.user;

public interface IUserGroup 
{
    Long getId();
	
	String getName();
	
	String getDescription();
	
	void setName(String name);
	
	void setDescription(String Description);
	
	String toString();
}
