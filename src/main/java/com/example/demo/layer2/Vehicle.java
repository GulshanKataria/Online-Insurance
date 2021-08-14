package com.example.demo.layer2;

import java.io.Serializable;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * The persistent class for the VEHICLE database table.
 * 
 */
@Entity
@Table(name="vehicle")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_ID")
	private int vehicleId;

	@Column(name="VEHICLE_CHASISNUMBER")
	private String vehicleChasisnumber;

	@Column(name="VEHICLE_DURATIONOFPOLICY")
	private int vehicleDurationofpolicy;

	@Column(name="VEHICLE_ENGINENUMBER")
	private String vehicleEnginenumber;

	@Column(name="VEHICLE_MANUFACTURE")
	private String vehicleManufacture;

	@Column(name="VEHICLE_MODEL")
	private String vehicleModel;

	@Column(name="VEHICLE_PLANTYPE")
	private int vehiclePlantype;

//	@Temporal(TemporalType.DATE)
	@Column(name="VEHICLE_PURCHASEDATE")
	private LocalDate vehiclePurchasedate;

	@Column(name="VEHICLE_REGISTRATIONNO")
	private String vehicleRegistrationno;

	@Column(name="VECHICLE_TYPE")
	private Integer vehicleType;
	

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="INSURANCE_ID")
	private Insurance insurance;
//
//	//bi-directional one-to-one association to Insurance
//	@OneToOne
//	@JoinColumn(name="INSURANCE_ID")
//	private Insurance insurance;

	public Vehicle() {
	}

	public int getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleChasisnumber() {
		return this.vehicleChasisnumber;
	}

	public void setVehicleChasisnumber(String vehicleChasisnumber) {
		this.vehicleChasisnumber = vehicleChasisnumber;
	}

	public int getVehicleDurationofpolicy() {
		return this.vehicleDurationofpolicy;
	}

	public void setVehicleDurationofpolicy(int vehicleDurationofpolicy) {
		this.vehicleDurationofpolicy = vehicleDurationofpolicy;
	}

	public String getVehicleEnginenumber() {
		return this.vehicleEnginenumber;
	}

	public void setVehicleEnginenumber(String vehicleEnginenumber) {
		this.vehicleEnginenumber = vehicleEnginenumber;
	}

	public String getVehicleManufacture() {
		return this.vehicleManufacture;
	}

	public void setVehicleManufacture(String vehicleManufacture) {
		this.vehicleManufacture = vehicleManufacture;
	}

	public String getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public int getVehiclePlantype() {
		return this.vehiclePlantype;
	}

	public void setVehiclePlantype(int vehiclePlantype) {
		this.vehiclePlantype = vehiclePlantype;
	}

	public LocalDate getVehiclePurchasedate() {
		return this.vehiclePurchasedate;
	}

	public void setVehiclePurchasedate(LocalDate vehiclePurchasedate) {
		this.vehiclePurchasedate = vehiclePurchasedate;
	}

	public String getVehicleRegistrationno() {
		return this.vehicleRegistrationno;
	}

	public void setVehicleRegistrationno(String vehicleRegistrationno) {
		this.vehicleRegistrationno = vehicleRegistrationno;
	}

	public Integer getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(Integer vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getCustomer() {
		return this.customer.getCustId();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
//
	public int getInsurance() {
		return this.insurance.getInsuranceId();
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

}