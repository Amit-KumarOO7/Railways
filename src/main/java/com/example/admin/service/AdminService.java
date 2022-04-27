package com.example.admin.service;

import java.util.ArrayList;


import antlr.collections.List;
import com.example.*;

import com.example.admin.*;
import com.example.admin.model.AdminDetails;
public interface AdminService {

    public AdminDetails createAdmin(AdminDetails admin);

	public ArrayList<AdminDetails> getAdmins();
}
