package com.admin.serviceImpl;

import com.admin.model.Admin;
import com.admin.repository.AdminRepo;
import com.admin.service.AdminService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminRepo adminRepo;
    @Override
    public Admin createAdmin(Admin admin) {
        adminRepo.save(admin);
        return admin;
    }
	@Override
	public ArrayList<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return  (ArrayList<Admin>) adminRepo.findAll();
	}
}
