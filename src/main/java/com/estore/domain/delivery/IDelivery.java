package com.estore.domain.delivery;

import java.util.Date;

public interface IDelivery {
	
	int getId();
	int getOrderId();
	Date getScheduledDate();
	Date getActualDate();
	int getAddressId();
	double getCost();
	int getStatus();
	String getTrackingUrl();
	void setOrderId(int id);
	void setScheduledDate(Date date);
	void setActualDate(Date date);
	void setAddressId(int id);
	void setCost(double cost);
	void setStatus(int status);
	void setTrackingUrl(String url);
	String toString();
}