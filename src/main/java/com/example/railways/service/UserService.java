package com.example.railways.service;


import com.example.railways.models.UserDetails;

public interface UserService {
    UserDetails createUser(UserDetails userDetails);

    UserDetails fetchByEmail(String emailId);
}