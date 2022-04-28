package com.example.railways.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
public class AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long adminId;
    
    @Column(unique = true)
    private String adminUsername;
    
    @Column
    private  String adminPassword;
    
    private int status=1;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AdminDetails(long adminId, String adminUsername, String adminPassword, int status) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.status = status;
	}

	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    

    
}
