package com.estore.service.order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.estore.domain.order.Order;
import com.estore.domain.order.OrderDetail;
import com.estore.domain.product.Product;

public class OrderTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("Estore");
	}

	@Before
    public void beforeEachTest() {
        em = emf.createEntityManager();
    }

	@After
    public void afterEachTest() {
        em.close();
    }
	
		
//	@Test
//	public void testInsert() {
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		IOrder order = new Order();
//		order.setAmount(20);
//		order.setCustomerId(1);
//		order.setOrderDate(new java.sql.Timestamp(System.currentTimeMillis()));
//		order.setPaymentId(1);
//		order.setStatus("pending");
//		
//		List<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>();
//		OrderDetail orderDetail = new OrderDetail();				
//		orderDetail.setQuantity(4);
//		orderDetail.setOrder((Order) order);
//		Product product = em.find(Product.class, 1);
//		orderDetail.setProduct(product);
//		
//		orderDetailsList.add(orderDetail);
//		order.setOrderDetails(orderDetailsList);
//		
//		
//		em.persist(order);
//		tx.commit();
//		
//		IOrder verification = findOrder(1);
//		assertEquals("Order Amount:", verification.getAmount(), order.getAmount(),0.0f);
//	}
	
	private IOrder findOrder(Integer orderId){
		return em.find(Order.class, orderId);
	}

}
