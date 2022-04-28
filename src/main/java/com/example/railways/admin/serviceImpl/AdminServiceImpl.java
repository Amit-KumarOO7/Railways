package com.example.railways.admin.serviceImpl;

import com.example.railways.admin.model.AdminDetails;
import com.example.railways.admin.repository.AdminRepo;
import com.example.railways.admin.service.AdminService;

import com.example.railways.exceptions.InvalidRequestException;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
	
	@Override
	public void deleteAdmin(String username) {
		// TODO Auto-generated method stub
		AdminDetails admin = adminRepo.getAdminByUsername(username);
		//System.out.println(username);
		
		if (admin==null) {
			throw new InvalidRequestException("Admin doesnt exist by that username");
		}
		  adminRepo.deleteAdmin(admin.getAdminId(),0);
	}

	@Override
	public void undeleteAdmin(String username) {
		
		AdminDetails admin = adminRepo.getAdminByUsername(username);
		if (admin==null) {
			throw new InvalidRequestException("Admin doesnt exist by that username");
		}
		  adminRepo.deleteAdmin(admin.getAdminId(),1);
		
	}
	

}
