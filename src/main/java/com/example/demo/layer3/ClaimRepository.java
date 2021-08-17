package com.example.demo.layer3;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Claim;
import com.example.demo.layer2.Travel;
import com.example.demo.layer2.Vehicle;


@Repository
public interface ClaimRepository {
	

	public void insertClaim(Claim claim);
	public List<Claim> selectClaimByInsuranceId(int insuranceId);
	public List<Claim> selectClaimByCustomerId(int customerId);
	public void updateClaim(int claimId);
	public List<Claim> selectClaimBetweenDates(LocalDate startDate, LocalDate endDate);
	public List<Claim> selectClaimBasedOnReasons(String claimReason);
	public List<Claim> selectClaimBasedOnAmountInsured(int amount);
	public List<Claim> selectClaimBasedOnAmountInRange(double startAmount, double endAmount);
	public List<Claim> selectClaimBasedOnMultipleReasons();
	public long countNoOfClaims();
	public List<Vehicle> selectVehicleByVehicleId(int vehicleId);
	public List<Vehicle> selectVehicleBetweenDates(LocalDate startDate, LocalDate endDate);
	public void updateVehicle(int vehicleId);
	public List<Vehicle> selectVehicleBasedOnDuration(int duration);
	public long countNoOfCars();
	public long countNoOfVehicles();
	public void deleteVehicle(int vehicleId);
	public List<Vehicle> selectVehicleByManufactures();
	public List<Travel> selectTravelByTravelId(int travelId);
	public List<Travel> selectTravelBetweenDates(LocalDate startDate, LocalDate endDate);
	public void updateTravel(int travelId);
	public List<Travel> selectTravelBasedOnAfterDate(LocalDate date);
	public long countNoOfParticularNomineeRelationship(String relation);
	public long countNoOfTravels();
	public void deleteTravel(int travelId);
	public List<Travel> selectTravelByDestinations();
	public List<Claim> selectAllClaims();
	
	
}
