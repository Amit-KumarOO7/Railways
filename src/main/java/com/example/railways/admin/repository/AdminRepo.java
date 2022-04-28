package com.example.railways.admin.repository;

import com.example.railways.admin.model.AdminDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminDetails, Long> {


    @Query("SELECT a FROM AdminDetails a WHERE a.adminUsername = ?1")
    AdminDetails getAdminByUsername(String username);



	
	@Query("UPDATE AdminDetais a SET a.status = :status WHERE a.adminId = :id")
	void deleteAdmin(@Param(value="id")Long id, @Param(value="status")int status);

	

}
