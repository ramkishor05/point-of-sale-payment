package com.brijframework.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.payment.entities.EOCustProductPurchasePayment;

@Repository
@Transactional
public interface CustProductPurchasePaymentRepository extends JpaRepository<EOCustProductPurchasePayment, Long> {

	List<EOCustProductPurchasePayment> findByCustProductPurchaseId(Long custProductPurchaseId);

}

