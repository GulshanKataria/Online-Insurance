package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Travel;

@Repository
public class TravelRepositoryImpl extends BaseRepository implements TravelRepository {

	@Transactional
	public Travel insertTravel(Travel tra) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(tra);
		System.out.println("travel inserted..."+tra);
		return tra;
	}
	
	@Transactional
	public List<Travel> selectTravelById(int travelId){
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectTravelById");
		Query query = entityManager.createQuery("select t from Travel t where t.travelid =: tid");
		query.setParameter("tid", travelId);
		List<Travel> travelList = query.getResultList();
		return travelList;
	}

	@Transactional
	public List<Travel> selectTravelByCustomerId(int customerId) {
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectTravelById");
		Query query = entityManager.createQuery("from Travel where CUST_ID =: cid");
		query.setParameter("cid", customerId);
		List<Travel> travelListCust = query.getResultList();
		return travelListCust;
		 
	}

	

}