package com.example.admin.serviceImpl;

import com.example.admin.model.AdminDetails;
import com.example.admin.repository.AdminRepo;
import com.example.admin.service.AdminService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
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
		// TODO Auto-generated method stub
		return  (ArrayList<AdminDetails>) adminRepo.findAll();
	}
	
}
