package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Payment;
import com.example.demo.layer4.PaymentServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/payment")

public class PaymentJPAController {

	@Autowired
	private PaymentServiceImpl service;

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getPayment/{insuranceId}")
	public List<Payment> getPaymentByInsuranceId(@PathVariable int insuranceId) {
		return service.selectPaymentByInsuranceIdService(insuranceId);
	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/addPayment")
	public Payment addPayment(@RequestBody Payment payment) {
		return service.insertPaymentService(payment);

	}
}
