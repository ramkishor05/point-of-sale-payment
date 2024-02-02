package com.brijframework.payment.service;

import java.util.List;

import com.brijframework.payment.rest.CustTransationRequest;
import com.brijframework.payment.rest.CustTransationResponse;

public interface CustTransationService {

	CustTransationResponse saveTransation(Long custAppId, CustTransationRequest custCashBookRequest);

	List<CustTransationResponse> getTransationList(Long custAppId, Long userId);

	CustTransationResponse getTransation(Long custAppId, Long id);

	boolean deleteTransation(Long custAppId, Long id);

	List<CustTransationResponse> getTransationFiltedList(Long custAppId, Long userId, String startDate, String endDate, List<String> serviceType);

}
