package com.example.railways.service;

import com.example.railways.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserSerive {

    public void addUser(UserDetails user);

}
