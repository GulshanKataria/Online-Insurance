package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Payment;
//import com.example.demo.layer2.PaymentNotFoundException;

@Repository
public interface PaymentRepository {
	
	
	List<Payment> selectPaymentByInsuranceId(int paymentId);
	/*
	 * List<Payment> insertPaymentByPaymentAmount(int paymentAmount);
	 */
	/* List<Payment> insertPaymentByInsuranceID(int InsuranceID); */
	
	Payment insertPayment(Payment pay);
	List<Payment> getAllPayment();
	
}