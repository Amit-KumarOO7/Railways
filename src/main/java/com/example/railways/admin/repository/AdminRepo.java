package com.example.railways.admin.repository;

import com.example.railways.admin.model.AdminDetails;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream
=======
import org.springframework.data.jpa.repository.Query;

>>>>>>> Stashed changes
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminDetails,Long> {

	
	@Query("SELECT * FROM AdminDetails a WHERE a.adminUsername = ?1")
	AdminDetails getAdminByUsername(String username);

	
	
}
