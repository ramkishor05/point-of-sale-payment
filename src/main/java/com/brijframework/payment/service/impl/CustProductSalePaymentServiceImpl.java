package com.brijframework.payment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.payment.entities.EOCustAccount;
import com.brijframework.payment.entities.EOCustBusinessApp;
import com.brijframework.payment.entities.EOCustProductSalePayment;
import com.brijframework.payment.mapper.CustProductSalePaymentMapper;
import com.brijframework.payment.repository.CustBusinessAppRepository;
import com.brijframework.payment.repository.CustProductSalePaymentRepository;
import com.brijframework.payment.rest.CustProductSalePayment;
import com.brijframework.payment.service.CustAccountService;
import com.brijframework.payment.service.CustProductSalePaymentService;

@Service
public class CustProductSalePaymentServiceImpl implements CustProductSalePaymentService {

	@Autowired
	private CustProductSalePaymentRepository custProductSalePaymentRepository;

	@Autowired
	private CustProductSalePaymentMapper custProductSalePaymentMapper;
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;

	@Autowired
	private CustAccountService custAccountService;

	@Override
	public CustProductSalePayment saveProductSalePayment( Long custAppId,
			CustProductSalePayment custProductSalePayment) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductSalePayment eoCustProductSalePayment=custProductSalePaymentMapper.mapToDAO(custProductSalePayment);
		EOCustAccount currentAccount = custAccountService.getCurrentAccount(eoCustBusinessApp);
		if(eoCustProductSalePayment.getCustTransaction()!=null) {
			if(eoCustProductSalePayment.getCustTransaction().getId()==0l) {
				eoCustProductSalePayment.getCustTransaction().setId(null);
				eoCustProductSalePayment.getCustTransaction().setCustAccount(currentAccount);
			}
		}
		
		custProductSalePaymentRepository
				.saveAndFlush(eoCustProductSalePayment);
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
