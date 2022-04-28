package com.example.railways.utils;

import org.springframework.stereotype.Service;

import com.example.railways.admin.model.AdminDetails;
import com.example.railways.exceptions.InvalidRequestException;
import com.example.railways.models.RouteDetails;
import com.example.railways.models.UserDetails;

@Service
public class Validations {

	
	
	public void addRouteValidations(RouteDetails routeDetails) {
		
		if(routeDetails.getFromId().getpId() <= 0) {
			throw new InvalidRequestException("From Id should not be null");
		}
		

		if(routeDetails.getToId().getpId() <= 0) {
			throw new InvalidRequestException("To Id should not be null");
		}
		

		if(routeDetails.getTrainName().equals("")) {
			throw new InvalidRequestException("Train name should not be null");
		}
		
	}

	public void createUserValidation(UserDetails userDetails) {
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if(userDetails.getuEmailId().matches(emailRegex) == true) {
			
		}else {
			throw new InvalidRequestException("Invalid email id");
		}
		
		
	}

	public void adminValidation(AdminDetails admin) {
		if(admin.getAdminUsername().isBlank()||admin.getAdminUsername().isEmpty())
			throw new InvalidRequestException("Invalid Username");
		if(admin.getAdminPassword().length()<8)
			throw new InvalidRequestException("Password must be 8 or more characters");
			
	}

}
