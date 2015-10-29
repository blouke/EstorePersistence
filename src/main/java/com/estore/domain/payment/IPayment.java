package com.estore.domain.payment;
import java.util.Date;

public interface IPayment {
	Long getId();
	Long getBillingAddressId();
	Long getOrderId();
	Date getDate();
	String getPaymentGateway();
	int getStatus();
	String getTransactionNumber();
	
	void setId(Long id);
	void setBillingAddressId(Long billingAddressId);
	void setOrderId(Long orderId);
	void setDate(Date date);
	void setPaymentGateway(String paymentGateway);
	void setStatus(int status);
	void setTransactionNumber(String transactionNumber);
	
	String toString();
}
