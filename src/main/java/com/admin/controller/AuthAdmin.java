package com.admin.controller;

import com.admin.model.Admin;
import com.admin.response.AdminDetailsResponse;
import com.admin.service.AdminService;

import java.util.Date;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthAdmin {

    @Autowired
    AdminService adminService;
    @PostMapping("createAdmin")
    public ResponseEntity<Object> createAdmin(@RequestBody Admin admin){

   return new ResponseEntity<Object>( new AdminDetailsResponse(new Date(),"Admin added Successfully",adminService.createAdmin(admin)),HttpStatus.OK);
   
    
   }





}
