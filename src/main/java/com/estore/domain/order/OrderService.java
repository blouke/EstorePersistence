package com.estore.domain.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.estore.service.order.IOrder;
import com.estore.service.order.IOrderService;

public class OrderService implements IOrderService {

	private EntityManager em;
	
	
	public OrderService(){
		em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
	}
	
	@Override
	public int saveOrder(IOrder order) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
//		IOrder orderToUpdate;
//		if (order.getId()>0){
//			orderToUpdate = em.find(Order.class, order.getId());
//			orderToUpdate.setAmount(order.getAmount());
//			orderToUpdate.setCustomerId(order.getCustomerId());
//			orderToUpdate.setOrderDate(order.getOrderDate());
//			orderToUpdate.setPaymentId(order.getPaymentId());
//			orderToUpdate.setStatus(order.getStatus());
//			orderToUpdate.setOrderDetails(order.getOrderDetails());
//		} else {
//			orderToUpdate = order;
//		}
//		em.persist(orderToUpdate);
		
		em.persist(order);
		tx.commit();
		return order.getId();
	}

	@Override
	public void deleteOrder(int orderId) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		IOrder order = em.find(Order.class, orderId);
		em.remove(order);
		tx.commit();
	}

	@Override
	public List<OrderTO> getAllOrders() {
		List<OrderTO> orderTOList = new ArrayList<OrderTO>();
		List<IOrder> ordersList = em.createNamedQuery("Order.findAllOrders").getResultList();
		OrderTO orderTO = new OrderTO();
		
		for (IOrder order: ordersList){
			orderTO.orderId = order.getId();
			orderTO.orderTotal = order.getAmount();
			orderTO.paymentId = order.getPaymentId();
			orderTO.orderStatus = order.getStatus();
			orderTO.orderDate = order.getOrderDate().toString();
			orderTOList.add(orderTO);
		}
		return orderTOList;
	}

	@Override
	public IOrder findById(int orderId) {
//		return em.createNamedQuery("Order.findById", Order.class).
//				setParameter("id", orderId).getSingleResult();
		return em.find(Order.class, orderId);
	}

}
