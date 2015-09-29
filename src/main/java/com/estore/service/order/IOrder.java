package com.estore.service.order;

import java.sql.Timestamp;
import java.util.List;

import com.estore.domain.order.OrderDetail;

public interface IOrder {
	public int getId();
	public void setId(int id);
	public void setAmount(double amount);
	public void setCustomerId(int customerId);
	public void setOrderDate(Timestamp orderDate);
	public void setPaymentId(int paymentId);
	public void setStatus(String status);
	public void setOrderDetails(List<OrderDetail> orderDetails);
	public OrderDetail addOrderDetail(OrderDetail orderDetail);
	public OrderDetail removeOrderDetail(OrderDetail orderDetail);
	
	public double getAmount();
	public int getCustomerId();
	public Timestamp getOrderDate();
	public int getPaymentId();
	public String getStatus();
	public List<OrderDetail> getOrderDetails();
}
