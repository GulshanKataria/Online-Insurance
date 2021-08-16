package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Insurance;
import com.example.demo.layer2.Travel;
import com.example.demo.layer3.InsuranceRepositoryImpl;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	public InsuranceServiceImpl() {
		System.out.println("In layer 4");
	}

	@Autowired
	InsuranceRepositoryImpl insuranceRepo;

	@Override
	public Insurance insertInsuranceService(Insurance ins) {
		return insuranceRepo.insertInsurance(ins);

	}

	@Override
	public List<Insurance> selectCustomerByIdService(int customerId) {
		System.out.println("InsuranceServiceImpl: Layer 4 ");
		return insuranceRepo.selectCustomerById(customerId);
	}

	@Override
	public List<Travel> selectTravelByIdService(int travelId) {
		System.out.println("InsuranceServiceImpl: Layer 4 ");
		return insuranceRepo.selectTravelById(travelId);
	}

	@Override
	public void insertTravelService(Travel tra) {
		insuranceRepo.insertTravel(tra);

	}

}
