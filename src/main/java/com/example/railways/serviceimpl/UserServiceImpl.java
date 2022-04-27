package com.example.railways.serviceimpl;

import com.example.railways.models.UserDetails;
import com.example.railways.repository.AuthRepository;
import com.example.railways.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AuthRepository authRepository;

    @Override
    public UserDetails createUser(UserDetails userDetails) {
//        userDetails.setUPassword(encoder.encode(userDetails.getUPassword()));
        return authRepository.save(userDetails);
    }

    @Override
    public UserDetails fetchByEmail(String emailId) {
        UserDetails user = authRepository.fetchByEmail(emailId);
//		if (admin == null) {
//			throw new UsernameNotFoundException("Admin not found with this email");
//		}
        return user;
    }
}
