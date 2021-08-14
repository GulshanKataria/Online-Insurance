package com.example.demo.layer4;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.layer2.Vehicle;

import com.example.demo.layer3.VehicleRepositoryImpl;

@Service
public class VehicleServiceImpl implements VehicleService {

	public VehicleServiceImpl() {
		System.out.println("In layer 4 Vehicle Service");
	}

	@Autowired
	VehicleRepositoryImpl vehicleRepo;

	@Override
	public List<Vehicle> selectVehicleByCustomerIdService(int customerId) {
		System.out.println("VehicleServiceImpl: Layer 4 ");
		return vehicleRepo.selectVehicleByCustomerId(customerId);
	}

	@Override
	public void insertVehicleService(Vehicle vehicle) {
		vehicleRepo.insertVehicle(vehicle);
		
	}

	@Override
	public boolean findVehicleByRegsitartionNumberService(String registerNumber) {
		return vehicleRepo.findVehicleByRegsitrationNumber(registerNumber);
		
	}

}
