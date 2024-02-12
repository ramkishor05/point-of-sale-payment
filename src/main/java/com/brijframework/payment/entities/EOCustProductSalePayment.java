package com.brijframework.payment.entities;

import static com.brijframework.payment.contants.TableConstants.CUSTOMER_ID;
import static com.brijframework.payment.contants.TableConstants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.payment.contants.TableConstants.CUST_TRANSACTION_ID;
import static com.brijframework.payment.contants.TableConstants.EOCUST_PRODUCT_SALE_PAYMENT;
import static com.brijframework.payment.contants.TableConstants.PRIMARY_PAYMENT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_SALE_PAYMENT)
public class EOCustProductSalePayment extends EOCustObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = CUSTOMER_ID, nullable = false)
	private Long customerId;
	
	@Column(name = PRIMARY_PAYMENT, nullable = false)
	private Boolean primaryPayment;
	
	@Column(name = CUST_PRODUCT_SALE_ID)
	private Long custProductSaleId;
	
	@Column(name = CUST_TRANSACTION_ID)
	private Long custTransactionId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}

	public Long getCustProductSaleId() {
		return custProductSaleId;
	}

	public void setCustProductSaleId(Long custProductSaleId) {
		this.custProductSaleId = custProductSaleId;
	}

	public Long getCustTransactionId() {
		return custTransactionId;
	}

	public void setCustTransactionId(Long custTransactionId) {
		this.custTransactionId = custTransactionId;
	}

}
