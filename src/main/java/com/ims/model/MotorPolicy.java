package com.ims.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "motor_inc_policy")
public class MotorPolicy {

	@Id
	@GeneratedValue(generator = "motor_id_gen")
	@GenericGenerator(name = "motor_id_gen", strategy = "increment")
	private Integer id;
	private String code;
	private String name;
	private String dsc;
	private Integer duraction;
	@Column(name = "premium_amount")
	private Double premiumAmount;
	@Column(name = "coverage_amount")
	private Double coverageAmount;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "accept_claim_tab", joinColumns = @JoinColumn(name = "accept_id"))
	@OrderColumn(name = "pos")
	@Column(name = "claim")
	private List<String> acceptClaim;
	@Column(name = "motor_type")
	private String motorType;
	@Column(name = "coverage_duration")
	private Integer coverageDuraction;
	@Column(name = "cancel_allow")
	private String cancelAllow;
	private String status;
	private String rules;

	public MotorPolicy(Integer id, String code, String name, String dsc, Integer duraction, Double premiumAmount,
			Double coverageAmount, List<String> acceptClaim, String motorType, Integer coverageDuraction,
			String cancelAllow, String status, String rules) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.dsc = dsc;
		this.duraction = duraction;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.acceptClaim = acceptClaim;
		this.motorType = motorType;
		this.coverageDuraction = coverageDuraction;
		this.cancelAllow = cancelAllow;
		this.status = status;
		this.rules = rules;
	}

	public MotorPolicy() {
		super();
	}

	public MotorPolicy(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public Integer getDuraction() {
		return duraction;
	}

	public void setDuraction(Integer duraction) {
		this.duraction = duraction;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public List<String> getAcceptClaim() {
		return acceptClaim;
	}

	public void setAcceptClaim(List<String> acceptClaim) {
		this.acceptClaim = acceptClaim;
	}

	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	public Integer getCoverageDuraction() {
		return coverageDuraction;
	}

	public void setCoverageDuraction(Integer coverageDuraction) {
		this.coverageDuraction = coverageDuraction;
	}

	public String getCancelAllow() {
		return cancelAllow;
	}

	public void setCancelAllow(String cancelAllow) {
		this.cancelAllow = cancelAllow;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	@Override
	public String toString() {
		return "MotorPolicy [id=" + id + ", code=" + code + ", name=" + name + ", dsc=" + dsc + ", duraction="
				+ duraction + ", premiumAmount=" + premiumAmount + ", coverageAmount=" + coverageAmount
				+ ", acceptClaim=" + acceptClaim + ", motorType=" + motorType + ", coverageDuraction="
				+ coverageDuraction + ", cancelAllow=" + cancelAllow + ", status=" + status + ", rules=" + rules + "]";
	}

}
