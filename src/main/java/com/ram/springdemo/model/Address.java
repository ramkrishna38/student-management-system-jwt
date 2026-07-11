package com.ram.springdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	private String street;
	
	private String city;
	
	private String pincode;
	
	public Address() {
		
	}
	
	public Address(Integer id, String street, String city, String pincode) {
		this.id=id;
		this.street=street;
		this.city=city;
		this.pincode=pincode;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street=street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public void setPincode(String pincode) {
		this.pincode=pincode;
	}
}
