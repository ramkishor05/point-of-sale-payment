package com.brijframework.payment.mapper;
import static com.brijframework.payment.contants.Constants.COM_BRIJFRAMEWORK_PAYMENT_MAPPER_IMPL;
import static com.brijframework.payment.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.payment.entities.EOCustAccount;
import com.brijframework.payment.rest.CustAccountResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PAYMENT_MAPPER_IMPL)
public interface CustAccountResponseMapper extends GenericMapper<EOCustAccount, CustAccountResponse>{

}
