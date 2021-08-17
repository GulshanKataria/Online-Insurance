package com.example.demo.layer2;

import java.io.Serializable;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * The persistent class for the CLAIM database table.
 * 
 */
@Entity()
@Table(name="claim")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLAIM_ID")
	private int claimId;

	@Column(name="CLAIM_AMOUNTINSURED")
	private double claimAmountinsured;

	@Column(name="CLAIM_APPROVALSTATUS")
	private int claimApprovalstatus;

//	@Temporal(TemporalType.DATE)
	@Column(name="CLAIM_DATEOFSUBMISSION")
	private LocalDate claimDateofsubmission;

	@Column(name="CLAIM_REASON")
	private String claimReason;

	//bi-directional one-to-one association to Insurance
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INSURANCEID")
	private Insurance insurance;

	public Claim() {
	}
	
	

	public Claim(double claimAmountinsured, int claimApprovalstatus, LocalDate claimDateofsubmission,
			String claimReason, Insurance insurance) {
		super();

		this.claimAmountinsured = claimAmountinsured;
		this.claimApprovalstatus = claimApprovalstatus;
		this.claimDateofsubmission = claimDateofsubmission;
		this.claimReason = claimReason;
		this.insurance = insurance;
	}



	public int getClaimId() {
		return this.claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public double getClaimAmountinsured() {
		return this.claimAmountinsured;
	}

	public void setClaimAmountinsured(double claimAmountinsured) {
		this.claimAmountinsured = claimAmountinsured;
	}

	public int getClaimApprovalstatus() {
		return this.claimApprovalstatus;
	}

	public void setClaimApprovalstatus(int claimApprovalstatus) {
		this.claimApprovalstatus = claimApprovalstatus;
	}

	public LocalDate getClaimDateofsubmission() {
		return this.claimDateofsubmission;
	}

	public void setClaimDateofsubmission(LocalDate claimDateofsubmission) {
		this.claimDateofsubmission = claimDateofsubmission;
	}

	public String getClaimReason() {
		return this.claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public Insurance getInsurance() {
		return this.insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

}