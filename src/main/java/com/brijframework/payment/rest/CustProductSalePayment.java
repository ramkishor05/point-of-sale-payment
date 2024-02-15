package com.brijframework.payment.rest;

import com.brijframework.payment.contants.PaymentState;
import com.brijframework.payment.dto.UIComman;
import com.brijframework.payment.dto.UICustTransaction;

public class CustProductSalePayment extends UIComman {

	private UICustTransaction custTransaction;
	
	private Long customerId;
	
	private Boolean primaryPayment;
	
	private Long custProductPurchaseId;
	
	private PaymentState paymentState;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public UICustTransaction getCustTransaction() {
		return custTransaction;
	}

	public void setCustTransaction(UICustTransaction custTransaction) {
		this.custTransaction = custTransaction;
	}

	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}

	public Long getCustProductPurchaseId() {
		return custProductPurchaseId;
	}

	public void setCustProductPurchaseId(Long custProductPurchaseId) {
		this.custProductPurchaseId = custProductPurchaseId;
	}

	public PaymentState getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(PaymentState paymentState) {
		this.paymentState = paymentState;
	}
}
