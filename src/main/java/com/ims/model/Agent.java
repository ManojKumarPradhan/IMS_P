package com.ims.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "agent_tab")
public class Agent {

	@Id
	@GeneratedValue(generator = "agent_id_gen")
	@GenericGenerator(name = "agent_id_gen", strategy = "increment")
	private Integer id;
	@Column(name = "agent_name")
	private String name;
	@Column(name = "agent_age")
	private Integer age;
	@Column(name = "photo_name")
	private String photoName;
	@Lob
	@Column(name = "photo_data")
	private byte[] photo;

	public Agent(Integer id, String name, Integer age, String photoName, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.photoName = photoName;
		this.photo = photo;
	}

	public Agent() {
		super();
	}

	public Agent(Integer id) {
		super();
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", age=" + age + ", photoName=" + photoName + ", photo="
				+ Arrays.toString(photo) + "]";
	}

}
