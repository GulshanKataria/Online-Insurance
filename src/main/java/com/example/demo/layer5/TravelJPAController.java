package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 
import com.example.demo.layer2.Travel;
 
import com.example.demo.layer4.TravelServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/travel")
public class TravelJPAController {

	public TravelJPAController() {
		System.out.println("In Layer 5");
	}

	
	@Autowired
	TravelServiceImpl traService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getTravel/{travelId}")
	public List<Travel> getTravelById(@PathVariable int travelId){
		System.out.println("in getInsuranceByCustomerId() ... method");
		return traService.selectTravelByIdService(travelId);
	}
	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getTravelByCustid/{customerId}")
	public List<Travel> getTravelByCustId(@PathVariable int customerId){
		System.out.println("in getInsuranceByCustomerId() ... method");
		return traService.selectTravelByCustomerIdService(customerId);
	}
	
	@PostMapping()
	@ResponseBody
	@RequestMapping(value = "/addTravel")
	public Travel addTravel(@RequestBody Travel travel) {
		
		 return traService.insertTravelService(travel);

	}
	
}