package com.madrone.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address implements Serializable {
	
	private static final long serialVersionUID = -5833762231605484421L;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int zipcode;
	
	public Address() {		
	}
	
	public Address(String addressLine1, String addressLine2, String city,
			String state, int zipcode) {
		this.addressLine1 = addressLine1;  
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	@Column(name = "address_line1", nullable = false)
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line2")
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zipcode", nullable = false)
	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Address {")
		.append("addressLine1=%s, ")
		.append("addressLine2=%s, ")
		.append("city=%s, ")
		.append("state=%s, ")
		.append("zipcode=%d")
		.append("}");
		
		return String.format(pattern.toString(), 
				addressLine1,
				addressLine2,
				city,
				state,
				zipcode
				);
	}		
}