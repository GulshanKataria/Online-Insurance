package com.example.demo.layer4;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Customer;

@Service
public interface CustomerRegisterationService {
	
	public Customer selectCustomerByIdService(int custId);
	
	public Customer saveCustomerService(Customer customer);
	
	public Customer fetchCustomerByEmailIdService(String email);
	
	public Customer updateCustomerService(Customer customer);
	
	public Customer fetchCustomerByEmailIdAndPasswordService(String email,String password);
	
	public Customer updateCustomerPasswordService(Customer customer);

}
