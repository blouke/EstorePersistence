package com.estore.service.order;

import java.util.List;

import com.estore.domain.order.OrderTO;

public interface IOrderService {
	void saveOrder(IOrder order);
	void deleteOrder(int orderId);
	List<OrderTO> getAllOrders();
	IOrder findById(int orderId);
}
