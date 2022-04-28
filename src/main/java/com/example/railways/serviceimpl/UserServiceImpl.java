package com.example.railways.serviceimpl;

import com.example.railways.models.UserDetails;
import com.example.railways.repository.UserRepository;
import com.example.railways.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository authRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails createUser(UserDetails userDetails) {
        userDetails.setUPassword(encoder.encode(userDetails.getUPassword()));
        return authRepository.save(userDetails);
    }

    @Override
    public UserDetails fetchByEmail(String emailId) {
        UserDetails user = authRepository.fetchByEmail(emailId);
        return user;
    }
}
