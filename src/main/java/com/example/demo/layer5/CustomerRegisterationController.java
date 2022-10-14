package com.example.demo.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Customer;

import com.example.demo.layer4.CustomerRegisterationServiceImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Customer")
public class CustomerRegisterationController {
	
	@Autowired
	private CustomerRegisterationServiceImpl service;
	
	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getCust/{custId}")
	public Customer getCustomer(@PathVariable int custId) {
		System.out.println("getEmployee()...method ");

		try {
			return service.selectCustomerByIdService(custId); // FROM THE DB
		} catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	@PostMapping("/registerCustomer")
	@ResponseBody
	public String registerCustomer(@RequestBody Customer customer){
		
		
		     String tempEmailId = customer.getCustEmail();
		     System.out.println(tempEmailId);
		     
		     
		
			
			 if(tempEmailId!= null && !"".equals(tempEmailId)) 
			 { 
               Customer customerObj=service.fetchCustomerByEmailIdService(tempEmailId);
				/* System.out.println(customerObj.getCustEmail()); */
			  
			 if(customerObj!=null) { 
				 
				 return "this email already exist please enter again";
			
			 }
			
			  
			}
			 
				service.saveCustomerService(customer);
				System.out.println("saved from controller ");
				return "Registeration successfull";
				
			 
			
	
		
	}
	
	@GetMapping("/fetchEmail/{email}")
	@ResponseBody
	public Customer fetchByEmail(@PathVariable String email) {
		
		/* String tempEmailId = customer.getCustEmail(); */
		Customer customerObj = service.fetchCustomerByEmailIdService(email);
		
		return customerObj;
		
		
		
	}
	
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		return service.updateCustomerService(customer);
		
	}
	
	
	@PostMapping("/login")
	public int loginUser(@RequestBody Customer customer) throws Exception{
		
		String tempEmailId= customer.getCustEmail();
		String tempPassword = customer.getCustPassword();
		
		Customer customerObj =null;
		
		if(tempEmailId!=null && tempPassword!=null) {
			customerObj = service.fetchCustomerByEmailIdAndPasswordService(tempEmailId,tempPassword);
//			System.out.println(customerObj.getCustContactnumber());

			
		}
		
		if(customerObj==null) {
		 return 0;
		}
		
		return customerObj.getCustId();
		
		
		
	}
	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getCust/{emailId}/{password}")
	public Customer fetchCustomerByEmailIdAndPassword(@PathVariable String emailId,@PathVariable String password) {
		
		
		
		return service.fetchCustomerByEmailIdAndPasswordService(emailId, password);
	}
	
	@PutMapping("/updateCustomerPassword")
	public String  updateCustomerPassword(@RequestBody Customer customer) {
		
		String tempEmailId= customer.getCustEmail();
		Customer customerObj=null;
		
		if(tempEmailId!=null) {
		 customerObj = service.fetchCustomerByEmailIdService(tempEmailId);
			
		}
		
		if(customerObj==null) {
			 return "enter valid email";
		}
		
		service.updateCustomerPasswordService(customer);
		
		return "password updated sucessfully";
		

		
	}
	


}
