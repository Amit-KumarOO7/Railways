package com.example.railways.repository;

import com.example.railways.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u WHERE u.u_email_id=?1")
    public User fetchByEmailId(String email);
}
