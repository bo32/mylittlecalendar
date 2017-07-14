package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Task {
	
	private long id;
	private String label;
	private String description;
	private boolean wholeDay;
	private Date from;
	private Date to;
	private Location location;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public boolean isWholeDay() {
		return wholeDay;
	}
	
	public void setWholeDay(boolean wholeDay) {
		this.wholeDay = wholeDay;
	}
	
	public Date getFrom() {
		return from;
	}
	
	public void setFrom(Date from) {
		this.from = from;
	}
	
	public Date getTo() {
		return to;
	}
	
	public void setTo(Date to) {
		this.to = to;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

}
