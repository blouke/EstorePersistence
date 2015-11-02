package com.estore.service.order;

import java.util.List;

import com.estore.domain.order.OrderDetail;

public interface ICart {
	public void setItems(List<OrderDetail> lineItems);
	public List<OrderDetail> getItems();
	public int getCount();
	public void addItem(IOrderDetail item);
	public void removeItem(Long lineItemId);
	public float getTotal();
}
