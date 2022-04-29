package com.example.railways.utils;


import com.example.railways.admin.model.AdminDetails;
import com.example.railways.exceptions.InvalidRequestException;
import com.example.railways.models.RouteDetails;
import com.example.railways.models.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class Validations {


    public void addRouteValidations(RouteDetails routeDetails) {
        if (routeDetails.getFromId().getpId() <= 0) {
            throw new InvalidRequestException("From Id should not be null");
        }

        if (routeDetails.getToId().getpId() <= 0) {
            throw new InvalidRequestException("To Id should not be null");
        }

        if (routeDetails.getTrainName().equals("")) {
            throw new InvalidRequestException("Train name should not be null");
        }
    }

    public void createUserValidation(UserDetails userDetails) {
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        String dobRegex = "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$";
        String aadhaarRegex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";

        if (userDetails.getuName() == null) {
            throw new InvalidRequestException("Fill username");
        }

        if (userDetails.getuAddress() == null) {
            throw new InvalidRequestException("Fill address");
        }

        if (userDetails.getuDob() == null) {
            throw new InvalidRequestException("Fill DOB");
        }

        if (userDetails.getuAge() <= 0) {
            throw new InvalidRequestException("Age invalid");
        }

        if (userDetails.getuAadhaar() == null) {
            throw new InvalidRequestException("Aadhaar invalid");
        }

        if (userDetails.getuEmailId() == null) {
            throw new InvalidRequestException("Fill email id");
        }

        if (userDetails.getuPassword() == null) {
            throw new InvalidRequestException("Fill password");
        }

        if (!userDetails.getuEmailId().matches(emailRegex)) {
            throw new InvalidRequestException("Invalid email id");
        }

        if (!userDetails.getuPassword().matches(passwordRegex)) {
            throw new InvalidRequestException("Invalid password");
        }

        if (!userDetails.getuDob().matches(dobRegex)) {
            throw new InvalidRequestException("Invalid dob");
        }

        if (!userDetails.getuAadhaar().matches(aadhaarRegex)) {
            throw new InvalidRequestException("Invalid aadhaar");
        }
    }

    public void adminValidation(AdminDetails admin) {
        if (admin.getAdminUsername() == null || admin.getAdminUsername().isEmpty())
            throw new InvalidRequestException("Invalid Username");
        if (admin.getAdminPassword().length() < 8)
            throw new InvalidRequestException("Password must be 8 or more characters");

    }

}
