package com.example.railways.controler;


import com.example.railways.models.PlaceDetails;
import com.example.railways.models.RouteDetails;
import com.example.railways.models.UserDetails;
import com.example.railways.response.ErrorResponse;
import com.example.railways.response.PlaceCreatedResponse;
import com.example.railways.response.RouteCreatedResponse;
import com.example.railways.response.UserCreatedResponse;
import com.example.railways.service.PlaceService;
import com.example.railways.service.RouteService;
import com.example.railways.service.UserService;
import com.example.railways.utils.UserCreateUtils;
import com.example.railways.utils.Validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class PostController {
    @Autowired
    UserService userService;

    @Autowired
    PlaceService placeService;

    @Autowired
    RouteService routeService;
    
    @Autowired
    Validations validations;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody UserDetails userDetails) {
    	
    	System.out.println(userDetails.getuEmailId());
    	
    	validations.createUserValidation(userDetails);
       

        UserDetails fetchAdmin = userService.fetchByEmail(userDetails.getuEmailId());
        if (fetchAdmin == null) {
            UserDetails user = userService.createUser(userDetails);
            UserCreatedResponse response = new UserCreatedResponse(new Date(), "User Created Successfully", "200", user);
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }
        ErrorResponse response = new ErrorResponse(new Date(), "User already present", "409");
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/addPlace")
    public ResponseEntity<Object> addPlace(@RequestBody PlaceDetails placeDetails) {
        if (placeDetails.getpName() == null) {
            ErrorResponse response = new ErrorResponse(new Date(), "Fill all the details", "409");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }

        PlaceDetails fetchPlace = placeService.fetchByPlaceName(placeDetails.getpName());
        if (fetchPlace == null) {
            PlaceDetails place = placeService.createPlace(placeDetails);
            PlaceCreatedResponse response = new PlaceCreatedResponse(new Date(), "Place Created Successfully", "200", place);
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }
        ErrorResponse response = new ErrorResponse(new Date(), "Place already present", "409");
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


    @PostMapping("/addRoute")
    public ResponseEntity<Object> addRoute(@RequestBody RouteDetails routeDetails) {
        
    	validations.addRouteValidations(routeDetails);

        PlaceDetails placeFrom = placeService.fetchByPlaceId(routeDetails.getFromId().getpId());
        PlaceDetails placeTo = placeService.fetchByPlaceId(routeDetails.getToId().getpId());

        if (placeFrom == null || placeTo == null) {
            ErrorResponse response = new ErrorResponse(new Date(), "Add Place first", "409");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }

        RouteDetails route = routeService.createRoute(routeDetails);
        route.getFromId().setpName(placeFrom.getpName());
        route.getToId().setpName(placeTo.getpName());
        RouteCreatedResponse response = new RouteCreatedResponse(new Date(), "Route Created Successfully", "200", route);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
