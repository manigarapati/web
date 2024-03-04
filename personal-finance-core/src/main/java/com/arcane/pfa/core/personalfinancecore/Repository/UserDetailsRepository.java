package com.arcane.pfa.core.personalfinancecore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.personalfinancecore.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

//	 UserDetails findUserDetailsByEmail(String email);
//	    UserDetails findUserDetailsByUsername(String username);
	
}
