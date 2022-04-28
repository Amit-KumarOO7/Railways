package com.example.railways.admin.serviceImpl;

import com.example.railways.admin.model.AdminDetails;
import com.example.railways.admin.repository.AdminRepo;
import com.example.railways.admin.service.AdminService;
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
        return (ArrayList<AdminDetails>) adminRepo.findAll();
    }

    @Override
    public void deleteAdmin(String username) {
        // TODO Auto-generated method stub
        AdminDetails admin = adminRepo.getAdminByUsername(username);
        adminRepo.delete(admin);
    }

}
