package com.jain.helloSpring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@IdClass(PersonKey.class)
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "person_name")
	private String name;
	
	@Id
	private String dob;
	private String address1;
	
	@Id
	private String zip;
	
	@Column(name = "Marital_Status")
	private String maritalStatus;
	
	@Column(name = "sex")
	private String gender;
	
	private String education;
	private String profession;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", dob=" + dob + ", address1=" + address1 + ", zip=" + zip + ", maritalStatus="
				+ maritalStatus + ", gender=" + gender + ", education=" + education + ", profession=" + profession
				+ "]";
	}
	
	public Person() {}
	
	public Person(String name, String dob, String address1, String zip, String maritalStatus, String gender,
			String education, String profession) {
		super();
		this.name = name;
		this.dob = dob;
		this.address1 = address1;
		this.zip = zip;
		this.maritalStatus = maritalStatus;
		this.gender = gender;
		this.education = education;
		this.profession = profession;
	}
	
	
		
}
