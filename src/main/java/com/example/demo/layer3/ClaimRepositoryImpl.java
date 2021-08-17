package com.example.demo.layer3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Claim;
import com.example.demo.layer2.Customer;
import com.example.demo.layer2.Travel;
import com.example.demo.layer2.Vehicle;

@Repository
public class ClaimRepositoryImpl extends BaseRepository implements ClaimRepository {



	
	@Transactional
	public void insertClaim(Claim claim) {
		EntityManager entityManager = getEntityManager(); 
		entityManager.persist(claim);
		System.out.println("claim inserted..." + claim); 
		}

	

	
	  @Transactional 
	  public List<Claim> selectClaimByCustomerId(int customerId) {
	  EntityManager entityManager = getEntityManager(); 
	  Customer customer =entityManager.find(Customer.class, customerId);
	  System.out.println("debug selectClaimByCustomerId"); 
	  Query query = entityManager. createQuery("select c from Claim c where c.insurance in (select i from Insurance i where i.customer =: custObj)" );
	  query.setParameter("custObj", customer);
	  List<Claim> claimList = query.getResultList(); 
	  return claimList; 
	  }
	 

	
	  @Transactional public void updateClaim(Claim claim) { 
		  EntityManager  entityManager = getEntityManager();

		  System.out.println("claim updation started "+claim); 
		  Claim updatedClaim =entityManager.merge(claim);
		  System.out.println("Claim updated "+updatedClaim);
	  }
	  
	
	
	/*@Transactional 
	public Claim insertClaim(Claim cla) { 
		EntityManager entityManager = getEntityManager(); 
		entityManager.persist(cla);
		System.out.println("Claim inserted..."+cla); 
		return cla; }
	 */
	
	
	@Transactional
	public List<Claim> selectClaimByInsuranceId(int insuranceId){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectClaimByInsuranceById");
		
		Query query = entityManager.createQuery("from Claim where INSURANCEID =: cid");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("cid", insuranceId);
		List<Claim> claList = query.getResultList();
		return claList;
	}
	
	
	/*
	 * @Transactional public List<Claim> selectClaimByCustomerId(int customerId){
	 * EntityManager entityManager = getEntityManager();
	 * System.out.println("debug selectClaimByCustomerById");
	 * 
	 * Query query = entityManager.
	 * createQuery("Select c from Claim c where c.INSURANCEID  in (select INSURANCE_ID i from Insurance where i.CUST_ID=:cid)"
	 * ); // Query query = entityManager.createQuery("select c from Claim c");
	 * 
	 * query.setParameter("cid", customerId); List<Claim> claList =
	 * query.getResultList(); return claList; }
	 */
	
	
	@Transactional
	public void updateClaim(int claimId)
	{
		EntityManager entityManager = getEntityManager();
		System.out.println("debug updateClaim");
		Query query = entityManager.createQuery("Update Claim  set CLAIM_APPROVALSTATUS=:aps where CLAIM_ID=:cid");
		query.setParameter("aps",1);
		query.setParameter("cid",claimId);
		
		query.executeUpdate();
		System.out.println("UPDATED");
		
	}
	
	
	
	@Transactional
	public List<Claim> selectClaimBetweenDates(LocalDate startDate, LocalDate endDate){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectClaimBetweenDates");
		
		Query query = entityManager.createQuery("from Claim where CLAIM_DATEOFSUBMISSION between :sdate AND :edate  ");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("sdate", startDate);
		query.setParameter("edate", endDate);
		List<Claim> claList = query.getResultList();
		return claList;
	}
	
	
	@Transactional
	public List<Claim> selectClaimBasedOnReasons(String claimReason)
	
	
	
	{
		
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectClaimBasedOnReasons");
		
		Query query = entityManager.createQuery("Select c from Claim c where c.CLAIM_REASON like %:reason%");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("reason", claimReason);
		List<Claim> claList = query.getResultList();
		return claList;
		
		
		
		
	}
	
	
	@Transactional
	public List<Claim> selectClaimBasedOnAmountInsured(int amount)
	
	
	
	{
		
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectClaimBasedOnAmountInsured");
		
		Query query = entityManager.createQuery("from Claim where CLAIM_AMOUNTINSURED >=:amount");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("amount", amount);
		List<Claim> claList = query.getResultList();
		return claList;
		
		
		
		
	}
	
	
	
	
	@Transactional
	public List<Claim> selectClaimBasedOnAmountInRange(double startAmount, double endAmount){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectClaimBetweenAmountInRange");
		
		Query query = entityManager.createQuery("from Claim where CLAIM_AMOUNTINSURED between :samount AND :eamount");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("samount", startAmount);
		query.setParameter("eamount", endAmount);
		List<Claim> claList = query.getResultList();
		return claList;
	}
	
	
	@Transactional
	public List<Claim> selectClaimBasedOnMultipleReasons(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectClaimByReason");
		
		Query query = entityManager.createQuery("from Claim where CLAIM_REASON IN :name",Claim.class);
		List<String> name = Arrays.asList("ACCIDENT", "DISASTER");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("name", name);
		List<Claim> claList = query.getResultList();
		return claList;
	}
	
	
	@Transactional
	public long countNoOfClaims(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug countNoOFClaims");
		
		Query query = entityManager.createQuery("select count(*) from Claim");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		 long claList = (long)query.getSingleResult();
		return claList;
	
}
	
	//--------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------
	// Vehicle Test cases
	
	

	@Transactional
	public List<Vehicle> selectVehicleByVehicleId(int vehicleId){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectVehicleByVehicleById");
		
		Query query = entityManager.createQuery("from Vehicle where VEHICLE_ID =: vid");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("vid", vehicleId);
		List<Vehicle> claList = query.getResultList();
		return claList;
	}
	
	
	
	@Transactional
	public List<Vehicle> selectVehicleBetweenDates(LocalDate startDate, LocalDate endDate){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectVehicleBetweenDates");
		
		Query query = entityManager.createQuery("from Vehicle where VEHICLE_PURCHASEDATE between :sdate AND :edate  ");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("sdate", startDate);
		query.setParameter("edate", endDate);
		List<Vehicle> claList = query.getResultList();
		return claList;
	}
	
	
	@Transactional
	public void updateVehicle(int vehicleId)
	{
		EntityManager entityManager = getEntityManager();
		System.out.println("debug updateVehicle");
		Query query = entityManager.createQuery("Update Vehicle  set VEHICLE_PLANTYPE=:aps where VEHICLE_ID=:vid");
		query.setParameter("aps",1);
		query.setParameter("vid",vehicleId);
		
		query.executeUpdate();
		System.out.println("UPDATED");
		
	}
	
	
	@Transactional
	public List<Vehicle> selectVehicleBasedOnDuration(int duration){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectVehicleBasedOnDuration");
		
		Query query = entityManager.createQuery("from Vehicle where VEHICLE_DURATIONOFPOLICY =: dur");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("dur", duration);
		List<Vehicle> claList = query.getResultList();
		return claList;
	}
	

	@Transactional
	public long countNoOfCars(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug countNoOFCars");
		
		Query query = entityManager.createQuery("select count(*) from Vehicle where VEHICLE_TYPE=:car ");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("car", 1);
		 long claList = (long)query.getSingleResult();
		return claList;
	
}
	
	@Transactional
	public long countNoOfVehicles(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug countNoOFVehicles");
		
		Query query = entityManager.createQuery("select count(*) from Vehicle");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		 long claList = (long)query.getSingleResult();
		return claList;
	
}
	
	@Transactional
	public void deleteVehicle(int vehicleId)
	{
		EntityManager entityManager = getEntityManager();
		System.out.println("debug deleteVehicle");
		Query query = entityManager.createQuery("delete from Vehicle where VEHICLE_ID=:vid");
		query.setParameter("vid",vehicleId);
		
		query.executeUpdate();
		System.out.println("DELETED");
		
	}
	
	
	@Transactional
	public List<Vehicle> selectVehicleByManufactures(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectVehicleByManufactures");
		
		Query query = entityManager.createQuery("from Vehicle where VEHICLE_MANUFACTURE IN :name",Vehicle.class);
		List<String> name = Arrays.asList("TATA", "Hyundai");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("name", name);
		List<Vehicle> claList = query.getResultList();
		return claList;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	
	//--------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------
	// Travel Test cases
	
	

	@Transactional
	public List<Travel> selectTravelByTravelId(int travelId){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectTravelByTravelById");
		
		Query query = entityManager.createQuery("from Travel where TRAVELID =: tid");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("tid", travelId);
		List<Travel> claList = query.getResultList();
		return claList;
	}
	
	
	
	@Transactional
	public List<Travel> selectTravelBetweenDates(LocalDate startDate, LocalDate endDate){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectTravelBetweenDates");
		
		Query query = entityManager.createQuery("from Travel where TRAVEL_STARTDATE between :sdate AND :edate  ");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("sdate", startDate);
		query.setParameter("edate", endDate);
		List<Travel> claList = query.getResultList();
		return claList;
	}
	
	
	@Transactional
	public void updateTravel(int travelId)
	{
		EntityManager entityManager = getEntityManager();
		System.out.println("debug updateTravel");
		Query query = entityManager.createQuery("Update Travel  set TRAVEL_POLICYPLAN=:aps where TRAVELID=:tid");
		query.setParameter("aps",1);
		query.setParameter("tid",travelId);
		
		query.executeUpdate();
		System.out.println("UPDATED");
		
	}
	
	
	@Transactional
	public List<Travel> selectTravelBasedOnAfterDate(LocalDate date){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectTravelBasedOnMembers");
		
		Query query = entityManager.createQuery("from Travel where TRAVEL_STARTDATE >: date");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("date", date);
		List<Travel> claList = query.getResultList();
		return claList;
	}
	

	@Transactional
	public long countNoOfParticularNomineeRelationship(String relation){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug countNoOfParticularNomineeRelationship");
		
		Query query = entityManager.createQuery("select count(*) from Travel where NOMINEE_RELATIONSHIP=:relation ");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("relation", relation);
		 long claList = (long)query.getSingleResult();
		return claList;
	
}
	
	@Transactional
	public long countNoOfTravels(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug countNoOFTravels");
		
		Query query = entityManager.createQuery("select count(*) from Travel");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		 long claList = (long)query.getSingleResult();
		return claList;
	
}
	
	@Transactional
	public void deleteTravel(int travelId)
	{
		EntityManager entityManager = getEntityManager();
		System.out.println("debug deleteTravel");
		Query query = entityManager.createQuery("delete from Travel where TRAVELID=:tid");
		query.setParameter("tid",travelId);
		
		query.executeUpdate();
		System.out.println("DELETED");
		
	}
	
	
	@Transactional
	public List<Travel> selectTravelByDestinations(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectTravelByDestinations");
		
		Query query = entityManager.createQuery("from Travel where TRAVEL_DESTINATION IN :name",Travel.class);
		List<String> name = Arrays.asList("Newyork", "London","Italy");
//		Query query = entityManager.createQuery("select c from Claim c");
		
		query.setParameter("name", name);
		List<Travel> claList = query.getResultList();
		return claList;
	}


	@Transactional
	public List<Claim> selectAllClaims(){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectAllClaims ");
		
		//Query query = entityManager.createQuery("from Claim where CLAIM_APPROVALSTATUS=:status");
		Query query = entityManager.createQuery("from Claim");
		
		//query.setParameter("status", 0);
		
		//query.setParameter("cid", insuranceId);
		List<Claim> admList = query.getResultList();
		return admList;
	}
	
	

	

}
