package com.example.railways.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.railways.model.Train;
import com.example.railways.service.TrainService;
import com.example.railways.repository.AdminRepository;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	AdminRepository AdminRepository;
	
	@Override
	public Train fetchTrainsByTrainNumber(int trainNumber) {
		// TODO Auto-generated method stub
		
		return AdminRepository.fetchTrainByTrainNumber(trainNumber);
	}

	@Override
	public Train createAdmin(Train trainDetails) {
		// TODO Auto-generated method stub
		return AdminRepository.save(trainDetails);
	}

	
	

}
