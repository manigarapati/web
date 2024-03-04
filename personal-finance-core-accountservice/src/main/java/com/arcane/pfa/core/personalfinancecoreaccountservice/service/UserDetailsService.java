package com.arcane.pfa.core.personalfinancecoreaccountservice.service;

import java.util.List;

import com.arcane.pfa.core.personalfinancecoreaccountservice.model.UserDetails;

public interface UserDetailsService {
	UserDetails createUserDetails(UserDetails userDetails);
	UserDetails updateUserDetails(UserDetails userDetails);
	UserDetails getUserDetails(Long userId);
	List<UserDetails> getAllUserDetails();
	String deleteUserDetails(Long userId);
	
}
