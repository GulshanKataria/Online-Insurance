package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
 
import com.example.demo.layer2.Travel;

@Repository
public interface TravelRepository {
	Travel insertTravel(Travel tra);
	List<Travel> selectTravelById(int travelId);
	List<Travel> selectTravelByCustomerId(int customerId);
}
