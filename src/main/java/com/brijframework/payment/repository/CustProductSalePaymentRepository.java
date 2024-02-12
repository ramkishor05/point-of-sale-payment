package com.brijframework.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.payment.entities.EOCustProductSalePayment;

@Repository
@Transactional
public interface CustProductSalePaymentRepository extends JpaRepository<EOCustProductSalePayment, Long> {

	List<EOCustProductSalePayment> findByCustProductSaleId(Long custProductSaleId);

}

