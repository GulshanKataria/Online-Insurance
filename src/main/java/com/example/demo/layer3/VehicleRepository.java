package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Vehicle;


@Repository
public interface VehicleRepository {
	List<Vehicle> selectVehicleByCustomerId(int customerId);
	void insertVehicle(Vehicle vehicle);
	boolean findVehicleByRegsitrationNumber(String registerNumber);
	void updateVehicle(Vehicle vehicle);
}
