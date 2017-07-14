package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities;

import javax.persistence.Entity;

@Entity
public class Location {
	
	private long id;
	private double x;
	private double y;
	private String label;
	private String description;
	private String street;
	private String supplLocation;
	private String city;
	private String state;
	private String country;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getSupplLocation() {
		return supplLocation;
	}
	
	public void setSupplLocation(String supplLocation) {
		this.supplLocation = supplLocation;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

}
