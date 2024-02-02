package com.brijframework.payment.service;

import java.util.List;

import com.brijframework.payment.entities.EOCustAccount;
import com.brijframework.payment.entities.EOCustBusinessApp;
import com.brijframework.payment.rest.CustAccountRequest;
import com.brijframework.payment.rest.CustAccountResponse;

public interface CustAccountService {

	CustAccountResponse saveAccount(Long custAppId, CustAccountRequest custAccountRequest);

	List<CustAccountResponse> getAccountList(Long custAppId);

	List<CustAccountResponse> getAccountFiltedList(Long custAppId, String startDate, String endDate);

	CustAccountResponse getAccount(Long custAppId, Long id);

	boolean deleteAccount(Long custAppId, Long id);

	EOCustAccount getCurrentAccount(EOCustBusinessApp eoCustBusinessApp);

}
