package com.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer_tab")
public class Customer {

	@Id
	@GeneratedValue(generator = "customer_id_gen")
	@GenericGenerator(name = "customer_id_gen", strategy = "customer_id_gen")
	private Integer id;

	private String title;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "date_of_birth")
	private String dob;
	private String gender;
	@Column(name = "income_source")
	private String incomeSource;
	@Column(name = "yearly_income")
	private String yearlyImcome;
	private Double height;
	private Double weight;
	@Column(name = "blood_group")
	private String bloodGroup;
	private String cast;
	@Column(name = "maretial_status")
	private String maretialStatus;
	@Column(name = "spouce_name")
	private String spouceName;
	@Column(name = "child_name")
	private String childrenName;
	private String document;

	private String address1;
	private String address2;
	private String address3;

	private String email1;
	private String email2;

	private String contact1;
	private String contact2;

	private String website;
	private String language;
	private String source;

	public Customer(Integer id, String title, String firstName, String middleName, String lastName, String fatherName,
			String dob, String gender, String incomeSource, String yearlyImcome, Double height, Double weight,
			String bloodGroup, String cast, String maretialStatus, String spouceName, String childrenName,
			String document, String address1, String address2, String address3, String email1, String email2,
			String contact1, String contact2, String website, String language, String source) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.dob = dob;
		this.gender = gender;
		this.incomeSource = incomeSource;
		this.yearlyImcome = yearlyImcome;
		this.height = height;
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.cast = cast;
		this.maretialStatus = maretialStatus;
		this.spouceName = spouceName;
		this.childrenName = childrenName;
		this.document = document;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email1 = email1;
		this.email2 = email2;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.website = website;
		this.language = language;
		this.source = source;
	}

	public Customer() {
		super();
	}

	public Customer(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIncomeSource() {
		return incomeSource;
	}

	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}

	public String getYearlyImcome() {
		return yearlyImcome;
	}

	public void setYearlyImcome(String yearlyImcome) {
		this.yearlyImcome = yearlyImcome;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getMaretialStatus() {
		return maretialStatus;
	}

	public void setMaretialStatus(String maretialStatus) {
		this.maretialStatus = maretialStatus;
	}

	public String getSpouceName() {
		return spouceName;
	}

	public void setSpouceName(String spouceName) {
		this.spouceName = spouceName;
	}

	public String getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(String childrenName) {
		this.childrenName = childrenName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", title=" + title + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", fatherName=" + fatherName + ", dob=" + dob + ", gender=" + gender
				+ ", incomeSource=" + incomeSource + ", yearlyImcome=" + yearlyImcome + ", height=" + height
				+ ", weight=" + weight + ", bloodGroup=" + bloodGroup + ", cast=" + cast + ", maretialStatus="
				+ maretialStatus + ", spouceName=" + spouceName + ", childrenName=" + childrenName + ", document="
				+ document + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3
				+ ", email1=" + email1 + ", email2=" + email2 + ", contact1=" + contact1 + ", contact2=" + contact2
				+ ", website=" + website + ", language=" + language + ", source=" + source + "]";
	}

}
