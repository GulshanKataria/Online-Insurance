package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Travel;
import com.example.demo.layer3.TravelRepositoryImpl;
 
@Service
public class TravelServiceImpl implements TravelService{

	public TravelServiceImpl() {
		System.out.println("In layer 4");
	}
	
	@Autowired
	TravelRepositoryImpl traRepo;
	
	@Override
	public Travel insertTravelService(Travel tra) {
		return traRepo.insertTravel(tra);

	}

	@Override
	public List<Travel> selectTravelByIdService(int travelId) {
		System.out.println("InsuranceServiceImpl: Layer 4 ");
		return traRepo.selectTravelById(travelId);
	}

	@Override
	public List<Travel> selectTravelByCustomerIdService(int customerId) {
		// TODO Auto-generated method stub
		return traRepo.selectTravelByCustomerId(customerId);
	}

	

}