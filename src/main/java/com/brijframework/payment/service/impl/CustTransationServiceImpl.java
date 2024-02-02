package com.brijframework.payment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.payment.entities.EOCustAccount;
import com.brijframework.payment.entities.EOCustBusinessApp;
import com.brijframework.payment.entities.EOCustTransaction;
import com.brijframework.payment.mapper.CustTransationRequestMapper;
import com.brijframework.payment.mapper.CustTransationResponseMapper;
import com.brijframework.payment.repository.CustBusinessAppRepository;
import com.brijframework.payment.repository.CustCashBookRepository;
import com.brijframework.payment.rest.CustTransationRequest;
import com.brijframework.payment.rest.CustTransationResponse;
import com.brijframework.payment.service.CustAccountService;
import com.brijframework.payment.service.CustTransationService;

@Service
public class CustTransationServiceImpl implements CustTransationService {
	
	@Autowired
	private CustCashBookRepository custCashBookRepository;
	
	@Autowired
	private CustTransationResponseMapper custTransationResponseMapper;
	
	@Autowired
	private CustTransationRequestMapper custTransationRequestMapper;

	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;

	@Autowired
	private CustAccountService custAccountService;

	@Override
	public CustTransationResponse saveTransation(Long custAppId, CustTransationRequest custTransationRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		System.out.println("custTransationRequest="+custTransationRequest);
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustTransaction eoCustTransaction = custTransationRequestMapper.mapToDAO(custTransationRequest);
		eoCustTransaction.setTransactionService(custTransationRequest.getTransactionService());
		EOCustAccount currentAccount = custAccountService.getCurrentAccount(eoCustBusinessApp);
		eoCustTransaction.setCustAccount(currentAccount);
		custCashBookRepository.save(eoCustTransaction);
		return custTransationResponseMapper.mapToDTO(eoCustTransaction);
	}

	@Override
	public List<CustTransationResponse> getTransationList(Long custAppId, Long userId) {
		return custTransationResponseMapper.mapToDTO(custCashBookRepository.findAllByCustAppAndUserId(userId).orElse(new ArrayList<EOCustTransaction>())) ;
	}
	
	@Override
	public List<CustTransationResponse> getTransationFiltedList(Long custAppId, Long userId, String startDate,
			String endDate, List<String> serviceType) {
		return custTransationResponseMapper.mapToDTO(custCashBookRepository.findAllByCustAppAndUserId(userId, startDate, endDate, serviceType).orElse(new ArrayList<EOCustTransaction>())) ;
	}

	@Override
	public CustTransationResponse getTransation(Long custAppId, Long id) {
		return null;
	}

	@Override
	public boolean deleteTransation(Long custAppId, Long id) {
		return false;
	}

}
