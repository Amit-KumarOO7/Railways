package com.example.railways.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.railways.model.Train;

@Repository
public interface AdminRepository extends JpaRepository<Train, Long>{

	
	@Query("SELECT a FROM AdminDetails a WHERE a.emailId=?1")
	Train fetchTrainByTrainNumber(int trainNumber);

}
