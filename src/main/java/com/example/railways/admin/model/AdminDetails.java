package com.example.railways.admin.model;

import javax.persistence.*;


@Entity
public class AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    long adminId;
    @Column(unique = true)
    private
    String adminUsername;

    @Column
    private
    String adminPassword;


    public AdminDetails(long adminId, String adminUsername, String adminPassword) {
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public AdminDetails() {
    }

    public long getAdminId() {
        return this.adminId;
    }

    public String getAdminUsername() {
        return this.adminUsername;
    }

    public String getAdminPassword() {
        return this.adminPassword;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
