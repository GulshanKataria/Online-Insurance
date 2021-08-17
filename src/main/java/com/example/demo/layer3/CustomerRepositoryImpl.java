package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Customer;




@Repository
public class CustomerRepositoryImpl extends BaseRepository implements CustomerRepository{
	
	

	@Transactional
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("layer 3 repo method called");
		EntityManager entityManager = getEntityManager();
		entityManager.persist(customer); //based on PK
		return customer;
	}
	
	
	
	
	@Transactional
	public Customer selectCustomerById(int custId) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Customer.class, custId);//based on PK
	}
	
	
	
	@Transactional
	public Customer fetchCustomerByEmailId(String emailId) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Customer customer=null;
		
		
        try {
		customer = entityManager.createQuery(
				  "SELECT c from Customer c WHERE c.custEmail = :emailId", Customer.class).
				  setParameter("emailId", emailId).getSingleResult();
        }catch(Exception e) {
        	
        }
		
		
		return customer;
	
			
			

	
		
		
	
	}


	@Transactional
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		EntityManager entityManager = getEntityManager();
		entityManager.merge(customer);
		
		return customer;
		
	}




	@Transactional
	public Customer fetchCustomerByEmailIdAndPassword(String email, String password) {
		
		EntityManager entityManager = getEntityManager();
		Customer customer=null;
		
		
        try {
		Query query = entityManager.createQuery(
				  "SELECT c from Customer c WHERE c.custEmail = :emailId and c.custPassword = :password", Customer.class);
		
		query.setParameter("emailId", email);
		query.setParameter("password",password);
		customer = (Customer) query.getSingleResult();
		return customer;
				 
        }catch(Exception e) {
        	
        }
		
		
		return customer;
	
		
		
		
	}




	@Transactional
	public Customer updateCustomerPassword(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer customerObj = null;
		
		String emailId=customer.getCustEmail();
		String password=customer.getCustPassword();
		
		
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select c from Customer c where c.custEmail=:emailId");
		query.setParameter("emailId", emailId);
		
		customerObj=(Customer) query.getSingleResult();
		
		customerObj.setCustPassword(password);
		
		return customerObj;
		
		
	}
	

	@Transactional
	public List<Customer> fetchAllCustomer() {


		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery(" from Customer");
		List<Customer> cusList = query.getResultList();
		System.out.println("emplist "+cusList.size());

		//tx.commit();
		return cusList;




	}

}
