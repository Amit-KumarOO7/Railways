package com.example.railways.controler;

import com.example.railways.model.User;
import com.example.railways.repository.UserFoundResponse;
import com.example.railways.repository.UserRepository;
import com.example.railways.response.NewUserResponse;
import com.example.railways.service.UserSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PostController {

    @Autowired
    private UserSerive userSerive;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody User user) {

        User u = userRepository.fetchByEmailId(user.getUEmailId());

        if(u == null) {
            userSerive.addUser(user);
            NewUserResponse newUserResponse = new NewUserResponse(new Date(), "User Created", "200", user);
            return new ResponseEntity<Object>(newUserResponse, HttpStatus.CREATED);
        } else {
            UserFoundResponse userFoundResponse = new UserFoundResponse(new Date(), "User already exists", "409");
            return new ResponseEntity<Object>(userFoundResponse, HttpStatus.CONFLICT);
        }
    }

//    @PostMapping
//    public ResponseEntity<Object> bookTicket(@RequestBody )
}
