package com.brijframework.payment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.payment.entities.EOCustProductPurchasePayment;
import com.brijframework.payment.mapper.CustProductPurchasePaymentMapper;
import com.brijframework.payment.repository.CustProductPurchasePaymentRepository;
import com.brijframework.payment.rest.CustProductPurchasePayment;
import com.brijframework.payment.service.CustProductPurchasePaymentService;

@Service
public class CustProductPurchasePaymentServiceImpl implements CustProductPurchasePaymentService {

	@Autowired
	private CustProductPurchasePaymentRepository custProductPurchasePaymentRepository;

	@Autowired
	private CustProductPurchasePaymentMapper custProductPurchasePaymentMapper;

	@Override
	public CustProductPurchasePayment saveProductPurchasePayment(
			CustProductPurchasePayment custProductPurchasePayment) {
		EOCustProductPurchasePayment eoCustProductPurchasePayment= custProductPurchasePaymentRepository
				.saveAndFlush(custProductPurchasePaymentMapper.mapToDAO(custProductPurchasePayment));
		return custProductPurchasePaymentMapper.mapToDTO(eoCustProductPurchasePayment);
	}

	@Override
	public List<CustProductPurchasePayment> saveProductPurchasePaymentList(
			List<CustProductPurchasePayment> custProductPaymentList) {
		List<EOCustProductPurchasePayment> returnCustProductPaymentList = new ArrayList<EOCustProductPurchasePayment>();
		for (EOCustProductPurchasePayment eoCustProductPurchasePayment : custProductPurchasePaymentMapper
				.mapToDAO(custProductPaymentList)) {
			returnCustProductPaymentList
					.add(custProductPurchasePaymentRepository.saveAndFlush(eoCustProductPurchasePayment));
		}
		return custProductPurchasePaymentMapper.mapToDTO(returnCustProductPaymentList);
	}

	@Override
	public List<CustProductPurchasePayment> getProductPurchasePayment(Long custProductPurchaseId) {
		return custProductPurchasePaymentMapper.mapToDTO(custProductPurchasePaymentRepository.findByCustProductPurchaseId(custProductPurchaseId));
	}

}
