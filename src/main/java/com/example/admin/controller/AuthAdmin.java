package com.example.admin.controller;

import com.example.admin.model.AdminDetails;
import com.example.admin.response.AdminDetailsResponse;
import com.example.admin.service.AdminService;

import antlr.collections.List;

import java.util.ArrayList;
import java.util.Date;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthAdmin {

    @Autowired
    AdminService adminService;
    @PostMapping("createAdmin")
    public ResponseEntity<Object> createAdmin(@RequestBody AdminDetails admin){

   return new ResponseEntity<Object>( new AdminDetailsResponse(new Date(),"Admin added Successfully",adminService.createAdmin(admin)),HttpStatus.OK);
   
    
   }
    
    @GetMapping("viewAdmins")
    public ArrayList<AdminDetails> getAdmin() {
    	return adminService.getAdmins();
    	
    }





}
