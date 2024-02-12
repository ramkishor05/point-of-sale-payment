package com.brijframework.payment.rest;

import com.brijframework.payment.dto.UIComman;

public class CustProductPurchasePayment extends UIComman {
	
	private Long supplierId;
	
	private Boolean primaryPayment;
	
	private Long custTransactionId;
	
	private Long custProductPurchaseId;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}

	public Long getCustTransactionId() {
		return custTransactionId;
	}

	public void setCustTransactionId(Long custTransactionId) {
		this.custTransactionId = custTransactionId;
	}

	public Long getCustProductPurchaseId() {
		return custProductPurchaseId;
	}

	public void setCustProductPurchaseId(Long custProductPurchaseId) {
		this.custProductPurchaseId = custProductPurchaseId;
	}
	
}
