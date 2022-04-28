package com.example.railways.controler;

import com.example.railways.models.PlaceDetails;
import com.example.railways.models.RouteDetails;
import com.example.railways.models.Train;
import com.example.railways.response.ErrorResponse;
import com.example.railways.response.GetPlaceResponse;
import com.example.railways.response.GetRouteResponse;
import com.example.railways.response.TicketsAvailableResponse;
import com.example.railways.service.PlaceService;
import com.example.railways.service.RouteService;
import com.example.railways.service.TicketService;
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
    TicketService ticketService;

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
    @GetMapping("/getTicketsAvailable")
    public ResponseEntity<Object> getTicketsAvailable(@RequestBody Train train) {
        int trainNumber = train.getTrainNumber();
        int available = ticketService.getTicketsAvailable(trainNumber);
        TicketsAvailableResponse response = new TicketsAvailableResponse(new Date(),"Get Tickets Available Successful","200",available);
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }
}
