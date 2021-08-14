package com.example.demo.layer4;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.Vehicle;

@Service
public interface VehicleService {

	List<Vehicle> selectVehicleByCustomerIdService(int customerId);
	void insertVehicleService(Vehicle vehicle);
	boolean findVehicleByRegsitartionNumberService(String registerNumber);
}
