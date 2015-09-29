package com.estore.domain.delivery;

import java.util.Date;

public interface IDelivery {
	
	Long getId();
	
	Long getOrderId();
	
	Date getScheduledDate();
	
	Date getActualDate();
	
	Long getAddressId();
	
	Double cost();
	
	Integer status();
	
	String getTrackingUrl();
	
	void setScheduledDate(Date date);
	
	void setActualDate(Date date);
	
	void setCost(Double cost);
	
	void setStatus(Integer status);
	
	void setTrackingUrl(String url);
	
	String toString();
}