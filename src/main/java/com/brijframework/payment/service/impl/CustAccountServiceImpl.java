package com.brijframework.payment.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.payment.entities.EOCustAccount;
import com.brijframework.payment.entities.EOCustBusinessApp;
import com.brijframework.payment.mapper.CustAccountRequestMapper;
import com.brijframework.payment.mapper.CustAccountResponseMapper;
import com.brijframework.payment.repository.CustAccountRepository;
import com.brijframework.payment.repository.CustBusinessAppRepository;
import com.brijframework.payment.rest.CustAccountRequest;
import com.brijframework.payment.rest.CustAccountResponse;
import com.brijframework.payment.service.CustAccountService;

@Service
public class CustAccountServiceImpl implements CustAccountService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustAccountRepository custAccountRepository;
	
	@Autowired
	private CustAccountRequestMapper custAccountRequestMapper;
	
	@Autowired
	private CustAccountResponseMapper custAccountResponseMapper;

	@Override
	public CustAccountResponse saveAccount(Long custAppId, CustAccountRequest custAccountRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustAccount eoCustAccount = custAccountRequestMapper.mapToDAO(custAccountRequest);
		eoCustAccount.setCustBusinessApp(eoCustBusinessApp);
		eoCustAccount=custAccountRepository.save(eoCustAccount);
		return custAccountResponseMapper.mapToDTO(eoCustAccount);
	}
	
	@Override
	public EOCustAccount getCurrentAccount(EOCustBusinessApp eoCustBusinessApp) {
		List<EOCustAccount> findAll = custAccountRepository.findAll();
		if(findAll.isEmpty()) {
			EOCustAccount eoCustAccount=new EOCustAccount();
			eoCustAccount.setAccountId(RandomUtils.nextLong());
			eoCustAccount.setCustBusinessApp(eoCustBusinessApp);
			custAccountRepository.save(eoCustAccount);
			return eoCustAccount;
		}
		return findAll.get(0);
	}

	@Override
	public List<CustAccountResponse> getAccountList(Long custAppId) {
		return custAccountResponseMapper.mapToDTO(custAccountRepository.findAllByCustAppAndUserId(custAppId).orElse(null));
	}

	@Override
	public List<CustAccountResponse> getAccountFiltedList(Long custAppId, String startDate, String endDate) {
		return custAccountResponseMapper.mapToDTO(custAccountRepository.findAllByCustAppAndUserId(custAppId, startDate, endDate).orElse(null));
	}

	@Override
	public CustAccountResponse getAccount(Long custAppId, Long id) {
		return null;
	}

	@Override
	public boolean deleteAccount(Long custAppId, Long id) {
		return false;
	}

}
