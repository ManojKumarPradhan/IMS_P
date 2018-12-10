package com.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "health_inc_tab")
public class HealthPolicy {

	@Id
	@GeneratedValue(generator = "health_id_gen")
	@GenericGenerator(name = "health_id_gen", strategy = "increment")
	private Integer id;
	private String code;
	private String name;
	private String dsc;
	@Column(name = "policy_amount")
	private Double policyAmount;
	@Column(name = "coverage_amount")
	private Double coverageAmount;
	private Integer duraction;
	private String doument;
	private String status;
	@Column(name = "coverage_mode")
	private String coverageMode;
	private String rules;

	public HealthPolicy(Integer id, String code, String name, String dsc, Double policyAmount, Double coverageAmount,
			Integer duraction, String doument, String status, String coverageMode, String rules) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.dsc = dsc;
		this.policyAmount = policyAmount;
		this.coverageAmount = coverageAmount;
		this.duraction = duraction;
		this.doument = doument;
		this.status = status;
		this.coverageMode = coverageMode;
		this.rules = rules;
	}

	public HealthPolicy() {
		super();
	}

	public HealthPolicy(Integer id) {
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

	public Double getPolicyAmount() {
		return policyAmount;
	}

	public void setPolicyAmount(Double policyAmount) {
		this.policyAmount = policyAmount;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Integer getDuraction() {
		return duraction;
	}

	public void setDuraction(Integer duraction) {
		this.duraction = duraction;
	}

	public String getDoument() {
		return doument;
	}

	public void setDoument(String doument) {
		this.doument = doument;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCoverageMode() {
		return coverageMode;
	}

	public void setCoverageMode(String coverageMode) {
		this.coverageMode = coverageMode;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	@Override
	public String toString() {
		return "HealthPolicy [id=" + id + ", code=" + code + ", name=" + name + ", dsc=" + dsc + ", policyAmount="
				+ policyAmount + ", coverageAmount=" + coverageAmount + ", duraction=" + duraction + ", doument="
				+ doument + ", status=" + status + ", coverageMode=" + coverageMode + ", rules=" + rules + "]";
	}

}
