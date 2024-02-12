package com.brijframework.payment.entities;

import static com.brijframework.payment.contants.TableConstants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.payment.contants.TableConstants.CUST_TRANSACTION_ID;
import static com.brijframework.payment.contants.TableConstants.EOCUST_PRODUCT_PURCHASE_PAYMENT;
import static com.brijframework.payment.contants.TableConstants.PRIMARY_PAYMENT;
import static com.brijframework.payment.contants.TableConstants.SUPPLIER_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PURCHASE_PAYMENT)
public class EOCustProductPurchasePayment extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = SUPPLIER_ID, nullable = false)
	private Long supplierId;
	
	@Column(name = PRIMARY_PAYMENT, nullable = false)
	private Boolean primaryPayment;

	@Column(name = CUST_PRODUCT_PURCHASE_ID)
	private Long custProductPurchaseId;

	@Column(name = CUST_TRANSACTION_ID)
	private Long custTransactionId;

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

	public Long getCustProductPurchaseId() {
		return custProductPurchaseId;
	}

	public void setCustProductPurchaseId(Long custProductPurchaseId) {
		this.custProductPurchaseId = custProductPurchaseId;
	}

	public Long getCustTransactionId() {
		return custTransactionId;
	}

	public void setCustTransactionId(Long custTransactionId) {
		this.custTransactionId = custTransactionId;
	}
}
