package com.arcane.pfa.core.personalfinancecoreaccountservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.personalfinancecoreaccountservice.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
