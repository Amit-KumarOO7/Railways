package com.admin.service;

import java.util.ArrayList;

import com.admin.model.Admin;

import antlr.collections.List;

public interface AdminService {

    public Admin createAdmin(Admin admin);

	public ArrayList<Admin> getAdmins();
}
