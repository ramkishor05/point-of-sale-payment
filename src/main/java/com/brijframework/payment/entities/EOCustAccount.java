package com.brijframework.payment.entities;

import static com.brijframework.payment.contants.Constants.ACCOUNT_ID;
import static com.brijframework.payment.contants.Constants.CLOSING_BALANCE;
import static com.brijframework.payment.contants.Constants.CLOSING_DATE;
import static com.brijframework.payment.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.payment.contants.Constants.EOCUST_ACCOUNT;
import static com.brijframework.payment.contants.Constants.OPENING_BALANCE;
import static com.brijframework.payment.contants.Constants.OPENING_DATE;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_ACCOUNT)
public class EOCustAccount extends EOEntityObject {
	

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	
	@Column(name = ACCOUNT_ID)
	private Long accountId;
	
	@Column(name = OPENING_DATE)
	private Date openingDate;
	
	@Column(name = OPENING_BALANCE)
	private Double openingBalance;
	
	@Column(name = CLOSING_DATE)
	private Date closingDate;
	
	@Column(name = CLOSING_BALANCE)
	private Double closingBalance;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;
	
	@OneToMany(mappedBy = "custAccount")
	private List<EOCustTransaction> custTransactions;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public List<EOCustTransaction> getCustTransactions() {
		return custTransactions;
	}

	public void setCustTransactions(List<EOCustTransaction> custTransactions) {
		this.custTransactions = custTransactions;
	}
}
