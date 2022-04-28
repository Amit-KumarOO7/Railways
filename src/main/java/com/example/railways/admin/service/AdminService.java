package com.example.railways.admin.service;

import java.util.ArrayList;

import com.example.railways.admin.model.AdminDetails;

public interface AdminService {

    public AdminDetails createAdmin(AdminDetails admin);

	public ArrayList<AdminDetails> getAdmins();

	public void deleteAdmin(String username);
}
