package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.layer2.Payment;
import com.example.demo.layer3.PaymentRepositoryImpl;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepositoryImpl payRepo;

	@Override
	public List<Payment> selectPaymentByInsuranceIdService(int insuranceId) {
		// TODO Auto-generated method stub
		
		return payRepo.selectPaymentByInsuranceId(insuranceId);
	}

	@Override
	public Payment insertPaymentService(Payment pay) {
		// TODO Auto-generated method stub
		 return payRepo.insertPayment(pay);
	}

	
	
//	public Payment insertPaymentService(Payment payment) {
//		
//		Payment paymentObj =null;
//		paymentObj=payRepo.insertPayment(payment);
//		
//		return paymentObj;
	

}