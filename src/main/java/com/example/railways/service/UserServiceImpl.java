package com.example.railways.service;

import com.example.railways.models.UserDetails;
import com.example.railways.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserSerive {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserDetails user) {
        userRepository.save(user);
    }
}
