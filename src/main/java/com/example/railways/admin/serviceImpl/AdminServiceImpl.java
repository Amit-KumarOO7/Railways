package com.example.railways.admin.serviceImpl;

import com.example.railways.admin.model.AdminDetails;
import com.example.railways.admin.repository.AdminRepo;
import com.example.railways.admin.service.AdminService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminRepo adminRepo;
    @Override
    public AdminDetails createAdmin(AdminDetails admin) {
        adminRepo.save(admin);
        return admin;
    }
	@Override
	public ArrayList<AdminDetails> getAdmins() {
		return  (ArrayList<AdminDetails>) adminRepo.findAll();
	}
	
}
