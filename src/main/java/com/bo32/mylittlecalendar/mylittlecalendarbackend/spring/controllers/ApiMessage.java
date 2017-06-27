package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

public class ApiMessage {

	public static final String SUCCESS = "Success";
	public static final String HOME = "Welcome home";
	
	private String status, message;

	public ApiMessage(String status, String message) {
		this.setStatus(status);
		this.setMessage(message);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
