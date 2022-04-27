package com.admin.repository;

import com.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
	
	@Query(" select ar from AdminRepo ar"+
			" where ar.adminUsername = :username ")
	Admin findByUsername(@Param("username") String username);
}
