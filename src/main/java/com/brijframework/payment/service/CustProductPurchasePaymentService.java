package com.brijframework.payment.service;

import java.util.List;

import com.brijframework.payment.rest.CustProductPurchasePayment;

public interface CustProductPurchasePaymentService {

	CustProductPurchasePayment saveProductPurchasePayment(CustProductPurchasePayment custProductPurchasePayment);

	List<CustProductPurchasePayment> saveProductPurchasePaymentList(List<CustProductPurchasePayment> custProductPaymentList);

	List<CustProductPurchasePayment> getProductPurchasePayment(Long custProductPurchaseId);

}
