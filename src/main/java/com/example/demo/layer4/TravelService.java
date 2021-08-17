package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Travel;

@Service
public interface TravelService {
	Travel insertTravelService(Travel tra);
	List<Travel> selectTravelByIdService(int travelId);
	List<Travel> selectTravelByCustomerIdService(int customerId);
}