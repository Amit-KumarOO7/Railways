package com.example.railways.controler;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class PostController {
    @Autowired
    UserService userService;

    public static boolean regexCheck(String regex, String text) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean isEmailAddressValid(String emailAddress) {
        return regexCheck("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", emailAddress);
    }

    public static boolean isPasswordValid(String password) {
        return regexCheck("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", password);
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody UserDetails userDetails) {
        if (
                userDetails.getUName() == null ||
                        userDetails.getUAddress() == null ||
                        userDetails.getUDob() == null ||
                        userDetails.getUAge() <= 0 ||
                        userDetails.getUEmailId() == null ||
                        userDetails.getUPassword() == null ||
                        !isEmailAddressValid(userDetails.getUEmailId()) ||
                        !isPasswordValid(userDetails.getUPassword())
        ) {
            ErrorResponse response = new ErrorResponse(new Date(), "Fill all the details", "409");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }

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
