package com.example.admin.response;

import com.example.admin.model.AdminDetails;

import java.util.Date;

public class AdminDetailsResponse {

	private Date date;
	private String messageString;
	private AdminDetails admin;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public AdminDetails getAdmin() {
		return admin;
	}
	public void setAdmin(AdminDetails admin) {
		this.admin = admin;
	}
	public AdminDetailsResponse(Date date, String messageString, AdminDetails admin) {
		super();
		this.date = date;
		this.messageString = messageString;
		this.admin = admin;
	}
	public AdminDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
