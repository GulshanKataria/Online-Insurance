package com.example.demo.layer2;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the INSURANCE database table.
 * 
 */

@Entity
@Table(name="insurance")
public class Insurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INSURANCE_ID")
	private int insuranceId;

	@Column(name="INSURANCE_AMOUNT")
	private double insuranceAmount;

	@Column(name="INSURANCE_ISACTIVE")
	private int insuranceIsactive;

//	@Temporal(TemporalType.DATE)
	@Column(name="INSURANCE_ISSUEDATE")
	private LocalDate insuranceIssuedate;

	@Column(name="INSURANCE_POLICYTYPE")
	private int insurancePolicytype;

	
	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;
	
	@OneToOne(mappedBy="insurance",  fetch = FetchType.LAZY)
	private Travel travel;
	
	@OneToOne(mappedBy="insurance",  fetch = FetchType.LAZY)
	private Vehicle vehicle;

//	//bi-directional one-to-one association to Claim
//	@OneToOne(mappedBy="insurance")
//	private Claim claim;
//
//	//bi-directional one-to-one association to Payment
//	@OneToOne(mappedBy="insurance")
//	private Payment payment;
//
//	//bi-directional one-to-one association to Travel
//	@OneToOne
//	@JoinColumn(name="TRAVELID")
//	private Travel travel;
//
//	//bi-directional one-to-one association to Vehicle
//	@OneToOne(mappedBy="insurance")
//	private Vehicle vehicle;

	public Insurance() {
	}
	
	

	public Insurance(int insuranceId) {
	super();
	this.insuranceId = insuranceId;
}



	public int getInsuranceId() {
		return this.insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public double getInsuranceAmount() {
		return this.insuranceAmount;
	}

	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public int getInsuranceIsactive() {
		return this.insuranceIsactive;
	}

	public void setInsuranceIsactive(int insuranceIsactive) {
		this.insuranceIsactive = insuranceIsactive;
	}

	public LocalDate getInsuranceIssuedate() {
		return this.insuranceIssuedate;
	}

	public void setInsuranceIssuedate(LocalDate insuranceIssuedate) {
		this.insuranceIssuedate = insuranceIssuedate;
	}

	public int getInsurancePolicytype() {
		return this.insurancePolicytype;
	}

	public void setInsurancePolicytype(int insurancePolicytype) {
		this.insurancePolicytype = insurancePolicytype;
	}

	public int getCustomer() {
		return this.customer.getCustId();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public Claim getClaim() {
//		return this.claim;
//	}
//
//	public void setClaim(Claim claim) {
//		this.claim = claim;
//	}
//
//	public Payment getPayment() {
//		return this.payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}
//
	public Travel getTravel() {
		return this.travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}
//
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}