package com.brijframework.payment.service;

import java.util.List;

import com.brijframework.payment.rest.CustProductSalePayment;

public interface CustProductSalePaymentService {

	CustProductSalePayment saveProductSalePayment(CustProductSalePayment custProductSalePayment);

	List<CustProductSalePayment> getProductSalePayment(Long custProductSaleId);

	List<CustProductSalePayment> saveProductSalePaymentList(List<CustProductSalePayment> custProductPaymentList);

}
