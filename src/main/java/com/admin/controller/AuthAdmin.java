package com.admin.controller;

import com.admin.model.Admin;
import com.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthAdmin {

    @Autowired
    AdminService adminService;
    @PostMapping("createAdmin")
    public Admin createAdmin(@RequestBody Admin admin) {
       return adminService.createAdmin(admin);
    }
}
