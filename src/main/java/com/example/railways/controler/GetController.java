package com.example.railways.controler;

import com.example.railways.models.PlaceDetails;
import com.example.railways.models.RouteDetails;
import com.example.railways.models.Train;
import com.example.railways.response.ErrorResponse;
import com.example.railways.response.GetPlaceResponse;
import com.example.railways.response.GetRouteResponse;
import com.example.railways.response.SeatsAvailableResponse;
import com.example.railways.service.PlaceService;
import com.example.railways.service.RouteService;
import com.example.railways.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class GetController {
    @Autowired
    PlaceService placeService;

    @Autowired
    RouteService routeService;

    @Autowired
    TrainService trainService;

    @GetMapping("/getPlaces")
    public ResponseEntity<Object> getPlaces() {
        List<PlaceDetails> fetchPlaces = placeService.getAllPlaces();
        GetPlaceResponse response = new GetPlaceResponse(new Date(), "Get Places successfully", "200", fetchPlaces);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getRoutes")
    public ResponseEntity<Object> getRoutes() {
        List<RouteDetails> fetchRoutes = routeService.getAllRoutes();
        GetRouteResponse response = new GetRouteResponse(new Date(), "Get Routes successfully", "200", fetchRoutes);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getRoutesBn")
    public ResponseEntity<Object> getRoutes(@RequestBody RouteDetails routeDetails) {
        if (routeDetails.getFromId() == null || routeDetails.getToId() == null) {
            ErrorResponse response = new ErrorResponse(new Date(), "Fill all the details", "409");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }

        List<RouteDetails> fetchRoutes = routeService.getAllRoutesBetween(routeDetails);
        GetRouteResponse response = new GetRouteResponse(new Date(), "Get Routes successfully", "200", fetchRoutes);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
    @GetMapping("/getSeatsAvailable")
    public ResponseEntity<Object> getSeatsAvailable(@RequestBody Train trainDetails) {
        int trainNumber = trainDetails.getTrainNumber();
        if(trainNumber == 0){
            ErrorResponse response = new ErrorResponse(new Date(), "Enter train number as trainNumber", "409");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }

        Train train = trainService.fetchTrainsByTrainNumber(trainNumber);
        if(train == null){
            ErrorResponse response = new ErrorResponse(new Date(), "Train doesn't exist", "409");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }
        int available = trainService.getAvailableSeats(trainNumber);
        SeatsAvailableResponse response = new SeatsAvailableResponse(new Date(),"Get Seats Available Successful","200",available);
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }
}
