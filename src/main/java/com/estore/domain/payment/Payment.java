package com.estore.domain.payment;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table (name = "PAYMENT")
public class Payment implements IPayment, Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name = "billing_address_id")
	@NotNull
	private Long billingAddressId;
	
	@Column(name = "order_id")
	@NotNull
	private Long orderId;
	
	@NotNull
	private Date date;
	
	@Column(name = "payment_gateway")
	@NotNull
	private String paymentGateway;
	
	@NotNull
	private int status;
	
	@Column(name = "transaction_number")
	@NotNull
	private String transactionNumber;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Long getBillingAddressId() {
		return billingAddressId;
	}

	@Override
	public Long getOrderId() {
		return orderId;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public String getPaymentGateway() {
		return paymentGateway;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getTransactionNumber() {
		return transactionNumber;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setBillingAddressId(Long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	@Override
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	@Override
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	@Override
    public String toString() {
        return "Payment{" + "id=" + id + ", billing address=" + billingAddressId + ", order id=" + orderId + ", DATE=" + date + ", payment gateway=" + paymentGateway + ", status=" + status +  ", transcation number=" + transactionNumber +'}';
    }
	
}

