package com.ims.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "emp_tab")
public class Employee {

	@Id
	@GeneratedValue(generator = "emp_id_gen")
	@GenericGenerator(name = "emp_id_gen", strategy = "increment")
	private Integer id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_mail")
	private String emailId;

	@Column(name = "emp_mobile")
	private String mobile;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "emp_roles", joinColumns = @JoinColumn(name = "emp_role_id"))
	@OrderColumn(name = "pos")
	@Column(name = "emp_roles")
	private List<String> roles;

	@Column(name = "address1")
	private String address1;

	private String address2;

	private String address3;

	@Column(name = "emp_id_type")
	private String idType;

	@Column(name = "emp_id_num")
	private String idNum;

	@Column(name = "file_name")
	private String docName;

	@Lob
	@Column(name = "emp_doc")
	private byte[] document;

	public Employee() {
		super();
	}

	public Employee(Integer id) {
		super();
		this.id = id;
	}

	public Employee(Integer id, String name, String emailId, String mobile, List<String> roles, String address1,
			String address2, String address3, String idType, String idNum, String docName, byte[] document) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.mobile = mobile;
		this.roles = roles;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.idType = idType;
		this.idNum = idNum;
		this.docName = docName;
		this.document = document;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
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

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", emailId=" + emailId + ", mobile=" + mobile + ", roles="
				+ roles + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", idType="
				+ idType + ", idNum=" + idNum + ", docName=" + docName + ", document=" + Arrays.toString(document)
				+ "]";
	}

}
