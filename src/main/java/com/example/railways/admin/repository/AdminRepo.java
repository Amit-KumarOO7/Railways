package com.example.railways.admin.repository;

import com.example.railways.admin.model.AdminDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminDetails,Long> {

	
}
