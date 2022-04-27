package com.example.railways.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.railways.model.Train;
import com.example.railways.response.TrainResponse;
import com.example.railways.service.TrainService;

@RestController
public class AddController {
	
	@Autowired
	TrainService trainService;
	
	@PostMapping("/addTrains") 
	public ResponseEntity<Object> createAdmin(@RequestBody Train trainDetails){
		
		Train train = trainService.fetchTrainsByTrainNumber(trainDetails.getTrainNumber());
		
		if(train != null) {
			TrainResponse trainResponse = new TrainResponse("Train with given number is already available");
			return new ResponseEntity<Object>(trainResponse, HttpStatus.OK);
		}
		
		Train newTrain = trainService.createAdmin(trainDetails);
		return new ResponseEntity<Object>(newTrain, HttpStatus.OK);
	}
	
	@GetMapping("/trains")
	public List<Train> fetchAllTrains()
	{
		List<Train> trains=trainService.fetchTrains();
		return trains;
	}
	

}
