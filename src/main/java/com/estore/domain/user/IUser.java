package com.estore.domain.user;

import java.util.Date;
import java.util.List;

import com.estore.domain.payment.Address;

public interface IUser 
{
	public int getId();
	public Date getCreateDate();
	public void setCreateDate(Date createDate);
	public String getEmail();
	public void setEmail(String email);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getPasswordHash();
	public void setPasswordHash(String passwordHash);
	public List<Address> getAddresses();
	public void setAddresses(List<Address> addresses);
	public Address addAddress(Address address);
	public Address removeAddress(Address address);
	public UserGroup getUserGroup();
	public void setUserGroup(UserGroup userGroup);
	
//	
//	Long getId();
//	
//	String getFirstName();
//	
//	String getLastName();
//	
//	String getEmail();
//	
//	String getPasswordHash();
//	
//	Date getDateTime();
//	
//	Long getGroupID();
//	
//	void setFirstName(String FirstName);
//	
//	void setLastName(String LastName);
//	
//	void setEmail(String Email);
//	
//	void setPasswordHash(String PasswordHash);
//	
//	void setDateTime(Date Datetime);
//	
//	void setGroupID(Long GroupID);
//	
//	String toString();
}
