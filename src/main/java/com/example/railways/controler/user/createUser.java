package com.example.railways.controler.user;

import com.example.railways.models.UserDetails;
import com.example.railways.response.ErrorResponse;
import com.example.railways.response.UserCreatedResponse;
import com.example.railways.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class createUser {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody UserDetails userDetails) {
        System.out.println(userDetails.getUEmailId());
        UserDetails fetchAdmin = userService.fetchByEmail(userDetails.getUEmailId());
        if (fetchAdmin == null) {
            UserDetails user = userService.createUser(userDetails);
            UserCreatedResponse response = new UserCreatedResponse(new Date(), "User Created Successfully", "200", user);
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }
        ErrorResponse response = new ErrorResponse(new Date(), "User already present", "409");
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
