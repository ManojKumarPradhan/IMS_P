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
@Table(name = "life_inc_policy")
public class LIfePolicy {

	@Id
	@GeneratedValue(generator = "life_policy_id_gen")
	@GenericGenerator(name = "life_policy_id_gen", strategy = "increment")
	private Integer id;
	@Column(name = "life_code")
	private String code;
	@Column(name = "life_name")
	private String name;
	private String dsc;
	private Integer duraction;
	@Column(name = "lock_period")
	private Integer lockPeriod;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "payment_mode", joinColumns = @JoinColumn(name = "payment_id"))
	@OrderColumn(name = "pos")
	@Column(name = "pay")
	private List<String> paymentMode;
	@Column(name = "premium_amount")
	private Double premiumAmount;
	@Column(name = "maturity_amount")
	private Double maturityAmount;
	@Column(name = "benifit_amount")
	private Double benifitAmount;
	@Column(name = "cancel_allow")
	private String cancelAllow;
	private String status;
	private String rules;

	public LIfePolicy(Integer id, String code, String name, String dsc, Integer duraction, Integer lockPeriod,
			Double premiumAmount, Double maturityAmount, Double benifitAmount, String cancelAllow, String status,
			String rules) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.dsc = dsc;
		this.duraction = duraction;
		this.lockPeriod = lockPeriod;
		this.premiumAmount = premiumAmount;
		this.maturityAmount = maturityAmount;
		this.benifitAmount = benifitAmount;
		this.cancelAllow = cancelAllow;
		this.status = status;
		this.rules = rules;
	}

	public LIfePolicy() {
		super();
	}

	public LIfePolicy(Integer id) {
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

	public Integer getLockPeriod() {
		return lockPeriod;
	}

	public void setLockPeriod(Integer lockPeriod) {
		this.lockPeriod = lockPeriod;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Double getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(Double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public Double getBenifitAmount() {
		return benifitAmount;
	}

	public void setBenifitAmount(Double benifitAmount) {
		this.benifitAmount = benifitAmount;
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

	public List<String> getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(List<String> paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "LIfePolicy [id=" + id + ", code=" + code + ", name=" + name + ", dsc=" + dsc + ", duraction="
				+ duraction + ", lockPeriod=" + lockPeriod + ", paymentMode=" + paymentMode + ", premiumAmount="
				+ premiumAmount + ", maturityAmount=" + maturityAmount + ", benifitAmount=" + benifitAmount
				+ ", cancelAllow=" + cancelAllow + ", status=" + status + ", rules=" + rules + "]";
	}

}
