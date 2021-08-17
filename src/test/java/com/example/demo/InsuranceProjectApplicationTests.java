package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.layer2.Claim;
import com.example.demo.layer2.Customer;
import com.example.demo.layer2.Insurance;
import com.example.demo.layer2.Payment;
import com.example.demo.layer2.Travel;
import com.example.demo.layer2.Vehicle;
import com.example.demo.layer3.ClaimRepositoryImpl;
import com.example.demo.layer3.CustomerRepositoryImpl;
import com.example.demo.layer3.PaymentRepositoryImpl;
import com.example.demo.layer4.ClaimServiceImpl;
import com.example.demo.layer4.CustomerRegisterationService;
import com.example.demo.layer4.PaymentServiceImpl;

@SpringBootTest
class InsuranceProjectApplicationTests {

	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String date = "2020-12-21";

    LocalDate claimDate = LocalDate.parse(date, formatter);
	
	@Autowired
	ClaimServiceImpl claService;
	
	@Autowired
	ClaimRepositoryImpl claRepo;
	
	
	@Autowired
	CustomerRepositoryImpl custRepo;

	@Autowired
	CustomerRegisterationService custSev;
	
	@Autowired
	private PaymentRepositoryImpl payRepo;
	
	@Autowired
	PaymentServiceImpl service;
	
	@Override
	public String toString() {
		return "InsuranceProjectApplicationTests [claRepo=" + claRepo + "]";
	}
	
	
	@Test
	void contextLoads() {
	}
	@Test
	//test 1
	void addClaim()
	{
		
		Insurance insuranceId=new Insurance(312);
		System.out.println("Adding claim...");
		Claim c1=new Claim(1500,0,claimDate,"Accident happened",insuranceId);
		claRepo.insertClaim(c1);
		System.out.println("Claim added");
		
	}
	
	
	
	@Test
	//test 2
	void selectClaimUsingInsuranceId()
	{
		System.out.println("Fetching claim...");
		List<Claim> claimList=claRepo.selectClaimByInsuranceId(301);
		for(Claim c:claimList) {
			System.out.println("Hi");
		System.out.println("ClaimID : " + c.getClaimId());
		System.out.println("Claim Reason : " + c.getClaimReason());
		System.out.println("Date of Submission : " + c.getClaimDateofsubmission());
		
		
		
		}
		
		
	}
	
	
	
	@Test
	// test 3
	void updateClaim()
	{
		
		
		System.out.println("Updating claim...");
		int claimId=26;
		claRepo.updateClaim(claimId);
		System.out.println("Claim Updated...");
		
	}
	
	
	
	
	@Test
	//test 4
	void selectClaimBetweenDates()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    String date1 = "2015-12-21";

	    LocalDate startDate= LocalDate.parse(date1, formatter);
	    
	    
	    

	    String date2 = "2020-12-21";

	    LocalDate endDate = LocalDate.parse(date2, formatter);
	    
	    
	
		System.out.println("Fetching claim...");
		List<Claim> claimList=claRepo.selectClaimBetweenDates(startDate,endDate);
		
		System.out.println(claimList);
		
		for(Claim c:claimList) {
			System.out.println("Hi");
		System.out.println("ClaimID : " + c.getClaimId());
		System.out.println("Claim Reason : " + c.getClaimReason());
		System.out.println("Date of Submission : " + c.getClaimDateofsubmission());
		
		
		
		}
	

}
	
//	@Test
//	void selectClaimBasedOnReason()
//	{
//		
//		System.out.println("Fetching claim...");
//		
//		List<Claim> claimList=claRepo.selectClaimBasedOnReasons("Accident");
//		System.out.println(claimList);
//		
//
//	}

	
	
	@Test
	//test 5
	void selectClaimBasedOnAmount()
	{
		
		System.out.println("Fetching claim...");
		
		List<Claim> claimList=claRepo.selectClaimBasedOnAmountInsured(1000);
		for(Claim c:claimList) {
			System.out.println("Hi");
		System.out.println("ClaimID : " + c.getClaimId());
		System.out.println("Claim Reason : " + c.getClaimReason());
		System.out.println("Date of Submission : " + c.getClaimDateofsubmission());
		
		
		
		}
		

	}
	
	
	
	@Test
	//test 6
	void selectClaimBasedOnBetweenAmounts()
	{
		
		System.out.println("Fetching claim...");
		
		List<Claim> claimList=claRepo.selectClaimBasedOnAmountInRange(1000,2500);
		for(Claim c:claimList) {
			System.out.println("Hi");
		System.out.println("ClaimID : " + c.getClaimId());
		System.out.println("Claim Reason : " + c.getClaimReason());
		System.out.println("Date of Submission : " + c.getClaimDateofsubmission());
		
		
		
		}
		

	}
	
	
	@Test 
	// test 7
	void selectClaimBasedOnMultipleReasons()
	{
		System.out.println("Fetching claim...");
		List<Claim> claimList=claRepo.selectClaimBasedOnMultipleReasons();
		//System.out.println(claimList.toString());
		for(Claim c:claimList) {
			System.out.println("Hi");
		System.out.println("ClaimID : " + c.getClaimId());
		System.out.println("Claim Reason : " + c.getClaimReason());
		System.out.println("Date of Submission : " + c.getClaimDateofsubmission());
		
		
		
		}
		
	}
	
	
	@Test
	//test 8
	void countNoOfClaims()
	{
		
		long claimList=claRepo.countNoOfClaims();
		
			System.out.println("Hi");
			System.out.println(claimList);
		
		
		
	
	
	}
	
	//Vehicle Testcases
	//-------------------------------------------------------------------------------
	// Test 1
	
	@Test
	
	void selectVehicleUsingVehicleId()
	{
		System.out.println("Fetching claim...");
		List<Vehicle> vehicleList=claRepo.selectVehicleByVehicleId(501);
		//System.out.println(claimList.toString());
		for(Vehicle v:vehicleList) {
			System.out.println("Hi");
		System.out.println("VehicleID : " + v.getVehicleId());
		System.out.println("Vehicle Model : " + v.getVehicleModel());
		System.out.println("Vehicle Type : " + v.getVehicleType());
		System.out.println("Vehicle Registration No : " + v.getVehicleRegistrationno());
		System.out.println("Vehicle Manufacture : " + v.getVehicleManufacture());
		System.out.println("Vehicle Purchase Date : " + v.getVehiclePurchasedate());
		System.out.println("Vehicle Engine Number : " + v.getVehicleEnginenumber());
		System.out.println("Vehicle Chasis Number : " + v.getVehicleChasisnumber());
		System.out.println("Vehicle Plan Type  : " + v.getVehiclePlantype());
		System.out.println("Vehicle Type : " + v.getVehicleDurationofpolicy());
	
		
		
		}
		
	}
	
	
	@Test
	// Test case 2
	void selectVehicleBetweenDates()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    String date1 = "2000-12-21";

	    LocalDate startDate= LocalDate.parse(date1, formatter);
	    
	    
	    

	    String date2 = "2020-12-21";

	    LocalDate endDate = LocalDate.parse(date2, formatter);
	    
	    
	
		System.out.println("Fetching vehicle...");
		List<Vehicle> vehicleList=claRepo.selectVehicleBetweenDates(startDate,endDate);
		int i=1;
		for(Vehicle v:vehicleList) {
			
		
		System.out.println("Vehicle-"+i);
		System.out.println("VehicleID : " + v.getVehicleId());
		System.out.println("Vehicle Model : " + v.getVehicleModel());
		System.out.println("Vehicle Type : " + v.getVehicleType());
		System.out.println("Vehicle Registration No : " + v.getVehicleRegistrationno());
		System.out.println("Vehicle Manufacture : " + v.getVehicleManufacture());
		System.out.println("Vehicle Purchase Date : " + v.getVehiclePurchasedate());
		System.out.println("Vehicle Engine Number : " + v.getVehicleEnginenumber());
		System.out.println("Vehicle Chasis Number : " + v.getVehicleChasisnumber());
		System.out.println("Vehicle Plan Type  : " + v.getVehiclePlantype());
		System.out.println("Vehicle Type : " + v.getVehicleDurationofpolicy());
		System.out.println("-------------------------------------------------------------");
		i=i+1;
		
		}
		
		
	

}
	
	
	
	@Test
	//Test 3
	void updateVehicle()
	{
		
		
		System.out.println("Updating vehicle...");
		int vehicleId=504;
		claRepo.updateVehicle(vehicleId);
		System.out.println("Vehicle Updated...");
		
	}
	@Test
	// Test 4
	
	void selectVehicleBasedOnDuration()
	{
		System.out.println("Fetching claim...");
		List<Vehicle> vehicleList=claRepo.selectVehicleBasedOnDuration(2);
		//System.out.println(claimList.toString());
		for(Vehicle v:vehicleList) {
			System.out.println("Hi");
		System.out.println("VehicleID : " + v.getVehicleId());
		System.out.println("Vehicle Model : " + v.getVehicleModel());
		System.out.println("Vehicle Type : " + v.getVehicleType());
		System.out.println("Vehicle Registration No : " + v.getVehicleRegistrationno());
		System.out.println("Vehicle Manufacture : " + v.getVehicleManufacture());
		System.out.println("Vehicle Purchase Date : " + v.getVehiclePurchasedate());
		System.out.println("Vehicle Engine Number : " + v.getVehicleEnginenumber());
		System.out.println("Vehicle Chasis Number : " + v.getVehicleChasisnumber());
		System.out.println("Vehicle Plan Type  : " + v.getVehiclePlantype());
		System.out.println("Vehicle Type : " + v.getVehicleDurationofpolicy());
	
		
		
		}
		
	}
	
	
	@Test
	//Test 5
	
	void countNoOfCars()
	{
		
		long vehicleList=claRepo.countNoOfCars();
		
			System.out.println("Hi");
			System.out.println(vehicleList);
		
		
		
	
	
	}
	
	
	
	
	
	@Test
	//Test 6
	
	
	
	void countNoOfVehicles()
	{
		
		long vehicleList=claRepo.countNoOfVehicles();
		
			System.out.println("Hi");
			System.out.println(vehicleList);
		
		
		
	
	
	}
	
	
	@Test
	//Test 7
	void deleteVehicle()
	{
		
		
		System.out.println("Delete vehicle...");
		int vehicleId=506;
		claRepo.deleteVehicle(vehicleId);
		System.out.println("Vehicle Deleted...");
		
	}
	
	
	@Test
	//Test 8
	void selectVehicleUsingManufactures()
	{
		System.out.println("Fetching vehicle...");
		List<Vehicle> vehicleList=claRepo.selectVehicleByManufactures();
		//System.out.println(claimList.toString());
		for(Vehicle v:vehicleList) {
			System.out.println("Hi");
		System.out.println("VehicleID : " + v.getVehicleId());
		System.out.println("Vehicle Model : " + v.getVehicleModel());
		System.out.println("Vehicle Type : " + v.getVehicleType());
		System.out.println("Vehicle Registration No : " + v.getVehicleRegistrationno());
		System.out.println("Vehicle Manufacture : " + v.getVehicleManufacture());
		System.out.println("Vehicle Purchase Date : " + v.getVehiclePurchasedate());
		System.out.println("Vehicle Engine Number : " + v.getVehicleEnginenumber());
		System.out.println("Vehicle Chasis Number : " + v.getVehicleChasisnumber());
		System.out.println("Vehicle Plan Type  : " + v.getVehiclePlantype());
		System.out.println("Vehicle Type : " + v.getVehicleDurationofpolicy());
	
		
		
		}
		
	}
		
//-------------------------------------------------------------------------------------------
// Test cases travel		
		
		
	// Test 1
	
	
	

	@Test
	void selectTravelUsingTravelId()
	{
		System.out.println("Fetching travel...");
		List<Travel> travelList=claRepo.selectTravelByTravelId(451);
		//System.out.println(claimList.toString());
		for(Travel t:travelList) {
			System.out.println("Hi");
		System.out.println("TravelID : " + t.getTravelid());
		System.out.println("Travel Destination : " + t.getTravelDestination());
		System.out.println("Travel Mode Of Travel : " + t.getTravelModeoftravel());
		System.out.println("Travel Start Date : " + t.getTravelStartdate());
		System.out.println("Travel End Date : " + t.getTravelEnddate());
		//System.out.println("Travel No of Members : " + t.getMembers());
		System.out.println("Travel Email : " + t.getTravelEmail());
		System.out.println("Travel Contact : " + t.getTravelContact());
		System.out.println("Nominee Name  : " + t.getNomineeName());
		System.out.println("Nominee Relationship : " + t.getNomineeRelationship());
	
		
		
		}
		
	}
	
	
	@Test
	// Test case 2
	void selectTravelBetweenDates()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    String date1 = "2000-12-20";

	    LocalDate startDate= LocalDate.parse(date1, formatter);
	    
	    
	    

	    String date2 = "2021-12-22";

	    LocalDate endDate = LocalDate.parse(date2, formatter);
	    
	    
	
		System.out.println("Fetching travel...");
		List<Travel> travelList=claRepo.selectTravelBetweenDates(startDate,endDate);
		int i=1;
		for(Travel t:travelList) {
			
		
		System.out.println("Travel-"+i);
		System.out.println("TravelID : " + t.getTravelid());
		System.out.println("Travel Destination : " + t.getTravelDestination());
		System.out.println("Travel Mode Of Travel : " + t.getTravelModeoftravel());
		System.out.println("Travel Start Date : " + t.getTravelStartdate());
		System.out.println("Travel End Date : " + t.getTravelEnddate());
		//System.out.println("Travel No of Members : " + t.getMembers());
		System.out.println("Travel Email : " + t.getTravelEmail());
		System.out.println("Travel Contact : " + t.getTravelContact());
		System.out.println("Nominee Name  : " + t.getNomineeName());
		System.out.println("Nominee Relationship : " + t.getNomineeRelationship());
		System.out.println("-------------------------------------------------------------");
		i=i+1;
		
		}
		
		
	

}
	
	
	
	@Test
	//Test 3
	void updateTravel()
	{
		
		
		System.out.println("Updating travel...");
		int travelId=451;
		claRepo.updateTravel(travelId);
		System.out.println("Travel Updated...");
		
	}
	@Test
	// Test 4
	
	void selectTravelBasedOnAfterDate()
	{
		System.out.println("Fetching travel...");
		String date1 = "2020-12-20";

	    LocalDate afterDate= LocalDate.parse(date1, formatter);
		List<Travel> travelList=claRepo.selectTravelBasedOnAfterDate(afterDate);
		//System.out.println(claimList.toString());
		for(Travel t:travelList) {
			System.out.println("TravelID : " + t.getTravelid());
			System.out.println("Travel Destination : " + t.getTravelDestination());
			System.out.println("Travel Mode Of Travel : " + t.getTravelModeoftravel());
			System.out.println("Travel Start Date : " + t.getTravelStartdate());
			System.out.println("Travel End Date : " + t.getTravelEnddate());
			//System.out.println("Travel No of Members : " + t.getMembers());
			System.out.println("Travel Email : " + t.getTravelEmail());
			System.out.println("Travel Contact : " + t.getTravelContact());
			System.out.println("Nominee Name  : " + t.getNomineeName());
			System.out.println("Nominee Relationship : " + t.getNomineeRelationship());
	
		
		
		}
		
	}
	
	
	@Test
	//Test 5
	
	void countNoOfParticularNomineeRelationship()
	{
		
		long travelList=claRepo.countNoOfParticularNomineeRelationship("Brother");
		
			System.out.println("Hi");
			System.out.println(travelList);
		
		
		
	
	
	}
	
	
	
	
	
	@Test
	//Test 6
	
	
	
	void countNoOfTravels()
	{
		
		long travelList=claRepo.countNoOfTravels();
		
			System.out.println("Hi");
			System.out.println(travelList);
		
		
	
	
	}
	
	
//	@Test
//	//Test 7
//	void deleteTravel()
//	{
//		
//		
//		System.out.println("Delete travel...");
//		int travelId=455;
//		claRepo.deleteTravel(travelId);
//		System.out.println("Travel Deleted...");
//		
//	}
	
	
	@Test
	//Test 8
	void selectVehicleUsingDestinations()
	{
		System.out.println("Fetching vehicle...");
		List<Travel> travelList=claRepo.selectTravelByDestinations();
		//System.out.println(claimList.toString());
		for(Travel t:travelList) {
			System.out.println("Hi");
			System.out.println("TravelID : " + t.getTravelid());
			System.out.println("Travel Destination : " + t.getTravelDestination());
			System.out.println("Travel Mode Of Travel : " + t.getTravelModeoftravel());
			System.out.println("Travel Start Date : " + t.getTravelStartdate());
			System.out.println("Travel End Date : " + t.getTravelEnddate());
			//System.out.println("Travel No of Members : " + t.getMembers());
			System.out.println("Travel Email : " + t.getTravelEmail());
			System.out.println("Travel Contact : " + t.getTravelContact());
			System.out.println("Nominee Name  : " + t.getNomineeName());
			System.out.println("Nominee Relationship : " + t.getNomineeRelationship());
		
		
		}

	
	
	
}
	
// --------------------------payment Testcases

	
	@Test
	public void insertPaymentTest() {
		Insurance insurance = new Insurance(305);
		System.out.println("Adding  a payment...");
		Payment payment = new Payment(4500,insurance);
		payRepo.insertPayment(payment);	
	}
	
	
	@Test
	public void deletePaymentTest() {
        
        payRepo.deletePayment(87);
	}
	
	@Test
	void updatePayment()
	{
		System.out.println("Updating payment...");
		int paymentId=701;
		payRepo.updatePayment(paymentId);
		System.out.println("Payment Updated...");
		
	}
	
	@Test
	void selectPaymentBasedOnBetweenAmounts()
	{
		System.out.println("Fetching payment...");
		
		List<Payment> paymentList=payRepo.selectPaymentBasedOnAmountInRange(1000,2500);
		for (Payment payment : paymentList) {
			System.out.println("PaymentId : "+payment.getPaymentId());
			System.out.println("PaymentAmount : "+payment.getPaymentAmount());
		}
	}
	
	@Test
	void loadAllPaymentTest() {
		System.out.println("Loading all the students...");
		List<Payment> paymentList = payRepo.getAllPayment();
		System.out.println("paymentList "+paymentList.size());
		for (Payment payment : paymentList) {
			System.out.println("PaymentId : "+payment.getPaymentId());
			System.out.println("PaymentAmount : "+payment.getPaymentAmount());
		}
	}
	
	

	
	
	
//----------------------------Customer Testcases
	

	@Test
	void createOneCustomerTest() {

		System.out.println("Creating  a customer...");
		Customer customer = new Customer();
		//customer.setCustId(873);

		customer.setCustFirstname("myFirstName1");
		customer.setCustLastname("myLastName1");
		customer.setCustEmail("new82@gmail.com");
		customer.setCustContactnumber("9080760");
		customer.setCustPassword("myPassword@"); 
		custRepo.saveCustomer(customer);

		System.out.println("customer inserted ");

		System.out.println(customer.getCustId());
		System.out.println(customer.getCustFirstname());
		System.out.println(customer.getCustLastname());
		System.out.println(customer.getCustEmail());
		System.out.println(customer.getCustPassword());

	}


	@Test
	void updateCustomerTest() {
		System.out.println("Updating a customer ");

		Customer customer;

		customer=custRepo.selectCustomerById(102);

		System.out.println(customer.getCustId());
		System.out.println(customer.getCustFirstname());
		System.out.println(customer.getCustLastname());
		System.out.println(customer.getCustEmail());
		System.out.println(customer.getCustPassword());

		customer.setCustEmail("newemail@gmail.com");



		custRepo.updateCustomer(customer);

		System.out.println("customer updated ");

		System.out.println(customer.getCustId());
		System.out.println(customer.getCustFirstname());
		System.out.println(customer.getCustLastname());
		System.out.println(customer.getCustEmail());
		System.out.println(customer.getCustPassword());

	}


	@Test
	void loadCustomerByIdTest() {


		System.out.println("Loading a customer...");
		Customer customer ;


		customer=custRepo.selectCustomerById(102);

		System.out.println("loading customer ");

		System.out.println(customer.getCustId());
		System.out.println(customer.getCustFirstname());
		System.out.println(customer.getCustLastname());
		System.out.println(customer.getCustEmail());
		System.out.println(customer.getCustPassword());


	}

	@Test
	void loadCustomerByEmailIdTest() {

		Customer customer;
		String tempEmail ="raja@gmail.com";


		customer =custRepo.fetchCustomerByEmailId(tempEmail);
		System.out.println("loading customer ");

		System.out.println(customer.getCustId());
		System.out.println(customer.getCustFirstname());
		System.out.println(customer.getCustLastname());
		System.out.println(customer.getCustEmail());
		System.out.println(customer.getCustPassword());
	}




	@Test
	void loadCustomerByEmailIdAndPasswordTest() {

		Customer customer;
		String tempEmail ="raja@gmail.com";
		String tempPassword = "Gulandas77!";

		customer =custRepo.fetchCustomerByEmailIdAndPassword(tempEmail,tempPassword);
		System.out.println("loading customer ");

		System.out.println(customer.getCustId());
		System.out.println(customer.getCustFirstname());
		System.out.println(customer.getCustLastname());
		System.out.println(customer.getCustEmail());
		System.out.println(customer.getCustPassword());
	}

	@Test
	void FetchAllCustomersTest() {
		System.out.println("Loading all the customers...");
		List<Customer> custList = custRepo.fetchAllCustomer();
		System.out.println("paymentList "+custList.size());
		for (Customer customer : custList) {

			System.out.println("loading customer ");

			System.out.println(customer.getCustId());
			System.out.println(customer.getCustFirstname());
			System.out.println(customer.getCustLastname());
			System.out.println(customer.getCustEmail());
			System.out.println(customer.getCustPassword());

		}



	}

	
	

	

	
	
	
	
	
	
	
	
	
}