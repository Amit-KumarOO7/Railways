package com.example.railways.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.railways.model.Train;

@RestController
public class AddController {
	
	@PostMapping("/addTrains") 
	public ResponseEntity<Object> createAdmin(@RequestBody Train trainDetails){
		return new ResponseEntity<Object>(trainDetails, HttpStatus.OK);
	}
	

}
