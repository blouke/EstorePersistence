package com.estore.service.order;

import java.util.List;

public interface IOrderService {
	void saveOrder(IOrder order);
	void deleteOrder(int orderId);
	List<IOrder> getAllOrders();
	IOrder findById(int orderId);
}
