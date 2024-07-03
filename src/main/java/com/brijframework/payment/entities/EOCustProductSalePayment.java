package com.brijframework.payment.entities;

import static com.brijframework.payment.contants.TableConstants.CUSTOMER_ID;
import static com.brijframework.payment.contants.TableConstants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.payment.contants.TableConstants.CUST_TRANSACTION_ID;
import static com.brijframework.payment.contants.TableConstants.EOCUST_PRODUCT_SALE_PAYMENT;
import static com.brijframework.payment.contants.TableConstants.PRIMARY_PAYMENT;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
	
	@Column(name = CUST_PRODUCT_SALE_ID, nullable = false)
	private Long custProductSaleId;
	
	@JoinColumn(name = CUST_TRANSACTION_ID, nullable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	private EOCustTransaction custTransaction;

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

	public EOCustTransaction getCustTransaction() {
		return custTransaction;
	}

	public void setCustTransaction(EOCustTransaction custTransaction) {
		this.custTransaction = custTransaction;
	}

}
