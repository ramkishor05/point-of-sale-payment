package com.brijframework.payment.mapper;
import static com.brijframework.payment.contants.Constants.COM_BRIJFRAMEWORK_PAYMENT_MAPPER_IMPL;
import static com.brijframework.payment.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.payment.entities.EOCustProductPurchasePayment;
import com.brijframework.payment.rest.CustProductPurchasePayment;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PAYMENT_MAPPER_IMPL)
public interface CustProductPurchasePaymentMapper extends GenericMapper<EOCustProductPurchasePayment, CustProductPurchasePayment>{

}
