package com.example.railways.admin.controller;

import com.example.railways.admin.model.AdminDetails;
import com.example.railways.admin.response.AdminDetailsResponse;
import com.example.railways.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class AuthAdmin {

    @Autowired
    AdminService adminService;

    @PostMapping("createAdmin")
    public ResponseEntity<Object> createAdmin(@RequestBody AdminDetails admin) {
        return new ResponseEntity<Object>(new AdminDetailsResponse(new Date(), "Admin added Successfully", adminService.createAdmin(admin)), HttpStatus.OK);


    }

    @GetMapping("viewAdmins")
    public ArrayList<AdminDetails> getAdmin() {
        return adminService.getAdmins();

    }

    @DeleteMapping("deleteAdmin")
    public void deleteAdmin(String username) {
        adminService.deleteAdmin(username);

    }


}




