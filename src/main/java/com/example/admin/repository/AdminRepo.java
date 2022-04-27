package com.example.admin.repository;

import com.example.admin.model.AdminDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminDetails,Long> {
	
	@Query(" select ar from AdminRepo ar"+
			" where ar.adminUsername = :username ")
	AdminDetails findByUsername(@Param("username") String username);
}
