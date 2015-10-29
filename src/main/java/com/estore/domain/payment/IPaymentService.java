package com.estore.domain.payment;

import java.util.List;

public interface IPaymentService {
	void deletePayment(int paymentId);

	List<IPayment> getAllPayments();
    
	void savePayment(IPayment payment);
    
	IPayment getPaymentById(Long id);
}