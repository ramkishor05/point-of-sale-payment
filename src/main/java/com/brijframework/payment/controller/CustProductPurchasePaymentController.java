package com.brijframework.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.payment.rest.CustProductPurchasePayment;
import com.brijframework.payment.service.CustProductPurchasePaymentService;

@RestController
@RequestMapping("/api/cust/purchase/payment")
public class CustProductPurchasePaymentController {

	@Autowired
	private CustProductPurchasePaymentService custProductPurchasePaymentService;
	
	@PostMapping
	public CustProductPurchasePayment saveProductPurchasePayment(@RequestBody CustProductPurchasePayment custProductPurchasePayment) {
		return custProductPurchasePaymentService.saveProductPurchasePayment(custProductPurchasePayment);
	}
	
	@GetMapping("/{custProductPurchaseId}")
	public List<CustProductPurchasePayment> getProductPurchasePayment(@PathVariable Long custProductPurchaseId) {
		return custProductPurchasePaymentService.getProductPurchasePayment(custProductPurchaseId);
	}
	
}
