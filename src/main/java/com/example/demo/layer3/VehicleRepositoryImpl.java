package com.example.demo.layer3;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Customer;
import com.example.demo.layer2.Travel;
import com.example.demo.layer2.Vehicle;

@Repository
public class VehicleRepositoryImpl extends BaseRepository implements VehicleRepository {

	@Transactional
	public void insertVehicle(Vehicle vehicle) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(vehicle);
		System.out.println("travel inserted..." + vehicle);
	}
	
	@Transactional
	public List<Vehicle> selectVehicleByCustomerId(int customerId) {	
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectVehicleByCustomerId");
		Customer customerObj = entityManager.find(Customer.class, customerId);
		Query query = entityManager.createQuery("select v from Vehicle v where v.customer =: custObj");
		query.setParameter("custObj", customerObj);
		List<Vehicle> vehicleList = query.getResultList();
		return vehicleList;
	}
	
	@Transactional
	public boolean findVehicleByRegsitrationNumber(String registerNumber) {
		EntityManager entityManager = getEntityManager();
		System.out.println("debug findVehicleByRegsitrationNumber");
		Vehicle vehicleObj = null;
		try {
		vehicleObj = entityManager.createQuery("select v from Vehicle v where v.vehicle"
				+ "Registrationno =: registerNo", Vehicle.class).setParameter("registerNo", registerNumber).getSingleResult();
		}
		catch(Exception e) {
			System.out.println("No vehicle Found for given Registration Number");
		}
		if(vehicleObj != null) {
			return true;
		}
		return false;
	}

	

}
