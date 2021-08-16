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

import com.example.demo.layer2.Insurance;
import com.example.demo.layer2.Travel;
import com.example.demo.layer2.Vehicle;
import com.example.demo.layer4.InsuranceServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/insurance")
public class InsuranceJPAController {

	
	public InsuranceJPAController() {
		System.out.println("In Layer 5 Insurance Controller");
	}

	
	@Autowired
	InsuranceServiceImpl insuranceService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getCustomer/{customerId}")
	public List<Insurance> getInsuranceByCustomerId(@PathVariable int customerId){
		System.out.println("in getInsuranceByCustomerId() ... method");
		return insuranceService.selectCustomerByIdService(customerId);
	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/addInsurance")
	public Insurance addInsurance(@RequestBody Insurance insurance) {
		return insuranceService.insertInsuranceService(insurance);
	 }
	
	
	
	
}
