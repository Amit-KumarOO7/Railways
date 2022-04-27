package com.example.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.type.TrueFalseType;

@Entity
public class AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adminId;
    @Column(unique = true)
    private String adminUsername;
    private String adminPassword;

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

    public AdminDetails( String adminUsername, String adminPassword) {
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public AdminDetails() {
    }
}
