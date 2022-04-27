package com.example.railways.service;

import java.util.List;

import com.example.railways.model.Train;

public interface TrainService {


	Train fetchTrainsByTrainNumber(int trainNumber);
	Train createAdmin(Train trainDetails);
	List<Train> fetchTrains();

}
