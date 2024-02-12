package com.brijframework.payment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.payment.entities.EOCustProductSalePayment;
import com.brijframework.payment.mapper.CustProductSalePaymentMapper;
import com.brijframework.payment.repository.CustProductSalePaymentRepository;
import com.brijframework.payment.rest.CustProductSalePayment;
import com.brijframework.payment.service.CustProductSalePaymentService;

@Service
public class CustProductSalePaymentServiceImpl implements CustProductSalePaymentService {

	@Autowired
	private CustProductSalePaymentRepository custProductSalePaymentRepository;

	@Autowired
	private CustProductSalePaymentMapper custProductSalePaymentMapper;

	@Override
	public CustProductSalePayment saveProductSalePayment(
			CustProductSalePayment custProductSalePayment) {
		EOCustProductSalePayment eoCustProductSalePayment= custProductSalePaymentRepository
				.saveAndFlush(custProductSalePaymentMapper.mapToDAO(custProductSalePayment));
		return custProductSalePaymentMapper.mapToDTO(eoCustProductSalePayment);
	}

	@Override
	public List<CustProductSalePayment> saveProductSalePaymentList(
			List<CustProductSalePayment> custProductPaymentList) {
		List<EOCustProductSalePayment> returnCustProductPaymentList = new ArrayList<EOCustProductSalePayment>();
		for (EOCustProductSalePayment eoCustProductSalePayment : custProductSalePaymentMapper
				.mapToDAO(custProductPaymentList)) {
			returnCustProductPaymentList
					.add(custProductSalePaymentRepository.saveAndFlush(eoCustProductSalePayment));
		}
		return custProductSalePaymentMapper.mapToDTO(returnCustProductPaymentList);
	}

	@Override
	public List<CustProductSalePayment> getProductSalePayment(Long custProductSaleId) {
		return custProductSalePaymentMapper.mapToDTO(custProductSalePaymentRepository.findByCustProductSaleId(custProductSaleId));
	}

}
