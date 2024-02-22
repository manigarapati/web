package com.arcane.pfa.core.personalfinanceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arcane.pfa.core.personalfinanceapplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 
	User findByEmailAndPassword(String email, String password);
}
