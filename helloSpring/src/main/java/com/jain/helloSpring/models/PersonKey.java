package com.jain.helloSpring.models;

import java.io.Serializable;

public class PersonKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String zip;
	private String name;
	private String dob;
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonKey other = (PersonKey) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}


	public PersonKey() {}
	
	public PersonKey(String zip, String name, String dob) {
		super();
		this.zip = zip;
		this.name = name;
		this.dob = dob;
		
	}

	

	@Override
	public String toString() {
		 String delimiter = "|";
		return zip + delimiter + name + delimiter + dob;
	}



	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}



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
	
	

}
