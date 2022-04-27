package com.admin.response;

import com.admin.model.Admin;

import java.util.Date;

public class AdminDetailsResponse {

	private Date date;
	private String messageString;
	private Admin admin;
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminDetailsResponse(Date date, String messageString, Admin admin) {
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
