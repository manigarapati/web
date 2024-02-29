package com.arcane.pfa.core.personalfinanceapplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arcane.pfa.core.personalfinanceapplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 
	User findByEmailAndPassword(String email, String password);
	
	@Query("SELECT u FROM User u WHERE u.dateJoined < :dateJoined")
    List<User> findInactiveUsers(@Param("dateJoined") LocalDate dateJoined);
}
