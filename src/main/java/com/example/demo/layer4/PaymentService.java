package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Payment;

@Service
public interface PaymentService {

	List<Payment> selectPaymentByInsuranceIdService(int insuranceId);

	Payment insertPaymentService(Payment pay);

}