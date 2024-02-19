package com.brijframework.payment.controller;

import static com.brijframework.payment.contants.Constants.CUST_APP_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.payment.rest.CustProductSalePayment;
import com.brijframework.payment.service.CustProductSalePaymentService;

@RestController
@RequestMapping("/api/cust/sale/payment")
public class CustProductSalePaymentController {

	@Autowired
	private CustProductSalePaymentService custProductSalePaymentService;
	
	@PostMapping
	public CustProductSalePayment saveProductSalePayment(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustProductSalePayment custProductSalePayment) {
		return custProductSalePaymentService.saveProductSalePayment(custAppId,custProductSalePayment);
	}
	
	@GetMapping("/{custProductSaleId}")
	public List<CustProductSalePayment> getProductSalePayment(@PathVariable Long custProductSaleId) {
		return custProductSalePaymentService.getProductSalePayment(custProductSaleId);
	}
	
}
