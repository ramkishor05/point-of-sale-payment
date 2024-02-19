package com.brijframework.payment.dto;

import java.util.Date;

import com.brijframework.payment.contants.TransactionMode;
import com.brijframework.payment.contants.TransactionStatus;
import com.brijframework.payment.contants.TransactionType;

public class UICustTransaction extends UIComman{
	private String transactionId;
	private Date transactionDate;
	private Double transactionAmount;
	private TransactionStatus transactionStatus;
	private TransactionType transactionType;
	private TransactionMode transactionMode;
	private Long transactionReciverId;
	private Long transactionSenderId;
	private Long transactionMakerId;
	private String transactionService;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionMode getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Long getTransactionReciverId() {
		return transactionReciverId;
	}

	public void setTransactionReciverId(Long transactionReciverId) {
		this.transactionReciverId = transactionReciverId;
	}

	public Long getTransactionSenderId() {
		return transactionSenderId;
	}

	public void setTransactionSenderId(Long transactionSenderId) {
		this.transactionSenderId = transactionSenderId;
	}

	public Long getTransactionMakerId() {
		return transactionMakerId;
	}

	public void setTransactionMakerId(Long transactionMakerId) {
		this.transactionMakerId = transactionMakerId;
	}

	public String getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(String transactionService) {
		this.transactionService = transactionService;
	}
}
