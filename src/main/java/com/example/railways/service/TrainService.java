package com.example.railways.service;

import com.example.railways.model.Train;

public interface TrainService {


	Train fetchTrainsByTrainNumber(int trainNumber);
	Train createAdmin(Train trainDetails);

}
