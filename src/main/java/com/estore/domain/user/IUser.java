package com.estore.domain.user;

import java.sql.Date;

public interface IUser 
{
	Long getID();
	
	String getFirstName();
	
	String getLastName();
	
	String getEmail();
	
	String getPasswordHash();
	
	Date getDateTime();
	
	Long getGroupID();
	
	void setFirstName(String FirstName);
	
	void setLastName(String LastName);
	
	void setEmail(String Email);
	
	void setPasswordHash(String PasswordHash);
	
	void setDateTime(Date Datetime);
	
	void setGroupID(Long GroupID);
	
	String toString();
}
