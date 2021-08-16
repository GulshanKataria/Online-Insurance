package com.example.demo.layer3;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Payment;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class PaymentRepositoryImpl extends BaseRepository implements PaymentRepository{
	
	public PaymentRepositoryImpl() {
		System.out.println("PaymentRepositoryImpl() constructed...");
		
	}
    @Transactional
	@Override
	public List<Payment> selectPaymentByInsuranceId(int insuranceId) {
		// TODO Auto-generated method stub
    	EntityManager entityManager = getEntityManager();
    	Query query = entityManager.createQuery("from Payment where INSURANCEID =: iid ");
    	query.setParameter("iid", insuranceId);
        List<Payment> payList = query.getResultList();
		return payList;
	}
    
    @Transactional
	public Payment insertPayment(Payment pay) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(pay);
		System.out.println("Payment added."+pay);
		return pay;
		
	}
    
	
	@Transactional
	public void updatePayment(int paymentId) {
		
			EntityManager entityManager = getEntityManager();
			System.out.println("debug updatePayment");
			Query query = entityManager.createQuery("Update Payment  set paymentAmount=:amt where paymentId =:pid");
			query.setParameter("amt", 1000.0);
			query.setParameter("pid",paymentId);
			
			query.executeUpdate();
			System.out.println("UPDATED");
			
		}
	
	
	@Transactional
	public void deletePayment(int paymentId) {
		EntityManager entityManager = getEntityManager();
		System.out.println("debug deletePayment");
		Query query = entityManager.createQuery("Delete from Payment where paymentId =:pid");
		query.setParameter("pid",paymentId);
		
		int rows = query.executeUpdate();
		System.out.println("Deleted"+rows);
		System.out.println("------------------------------------");
	}

	
	
	/*
	 * @Override public Payment insertPayment(int paymentId) { // TODO
	 * Auto-generated method stub return null; }
	 */

	/*
	 * @Override public List<Payment> insertPaymentByPaymentAmount(int
	 * paymentAmount) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public List<Payment> insertPaymentByInsuranceID(int InsuranceID) {
	 * // TODO Auto-generated method stub return null; }
	 */

@Transactional
public List<Payment> selectPaymentBasedOnAmountInRange(double startAmount, double endAmount){
	EntityManager entityManager = getEntityManager();
	System.out.println("debug selectPaymentBetweenAmountInRange");
	
	Query query = entityManager.createQuery("from Payment where paymentAmount between :samount AND :eamount");
//	Query query = entityManager.createQuery("select c from Claim c");
	
	query.setParameter("samount", startAmount);
	query.setParameter("eamount", endAmount);
	List<Payment> payList = query.getResultList();
	return payList;
}
@Override
public List<Payment> getAllPayment() {
	List<Payment> paymentList = entityManager.createQuery(" from Payment").getResultList();
	return paymentList;
}

}
