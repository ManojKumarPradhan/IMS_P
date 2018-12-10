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
@Table(name = "travel_inc_policy")
public class TravelPolicy {

	@Id
	@GeneratedValue(generator = "travel_inc_gen")
	@GenericGenerator(name = "travel_inc_gen", strategy = "increment")
	private Integer id;
	private String code;
	private String name;
	private String dsc;
	@Column(name = "policy_amount")
	private Double policyAmount;
	@Column(name = "coverage_amount")
	private Double coverageAmount;
	private Integer duraction;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "travel_types", joinColumns = @JoinColumn(name = "type_id"))
	@OrderColumn(name = "pos")
	@Column(name = "type")
	private List<String> types;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "travel_modes", joinColumns = @JoinColumn(name = "mode_id"))
	@OrderColumn(name = "pos")
	@Column(name = "mode")
	private List<String> modes;
	private String rules;

	public TravelPolicy(Integer id, String code, String name, String dsc, Double policyAmount, Double coverageAmount,
			Integer duraction, List<String> types, List<String> modes, String rules) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.dsc = dsc;
		this.policyAmount = policyAmount;
		this.coverageAmount = coverageAmount;
		this.duraction = duraction;
		this.types = types;
		this.modes = modes;
		this.rules = rules;
	}

	public TravelPolicy() {
		super();
	}

	public TravelPolicy(Integer id) {
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

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getModes() {
		return modes;
	}

	public void setModes(List<String> modes) {
		this.modes = modes;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	@Override
	public String toString() {
		return "TravelPolicy [id=" + id + ", code=" + code + ", name=" + name + ", dsc=" + dsc + ", policyAmount="
				+ policyAmount + ", coverageAmount=" + coverageAmount + ", duraction=" + duraction + ", types=" + types
				+ ", modes=" + modes + ", rules=" + rules + "]";
	}

}
