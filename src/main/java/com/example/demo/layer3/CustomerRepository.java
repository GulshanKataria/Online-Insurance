package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Customer;

@Repository
public interface CustomerRepository {

	public Customer selectCustomerById(int custId);

	public Customer saveCustomer(Customer customer);

	public Customer fetchCustomerByEmailId(String email);

	public Customer updateCustomer(Customer customer);

	public Customer fetchCustomerByEmailIdAndPassword(String email, String password);

	public Customer updateCustomerPassword(Customer customer);
	
	public List<Customer> fetchAllCustomer();

}
