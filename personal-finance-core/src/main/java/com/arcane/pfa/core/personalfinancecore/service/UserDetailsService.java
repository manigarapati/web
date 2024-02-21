package com.arcane.pfa.core.personalfinancecore.service;

import java.util.List;

import com.arcane.pfa.core.personalfinancecore.dto.UserDetailsRespone;
import com.arcane.pfa.core.personalfinancecore.model.UserDetails;

public interface UserDetailsService {
	UserDetails createUserDetails(UserDetails userDetails);
	UserDetails updateUserDetails(UserDetails userDetails);
	UserDetails getUserDetails(Long userId);
	List<UserDetails> getAllUserDetails();
	String deleteUserDetails(Long userId);
	//UserDetails checkUserStatus(String email);
	
}
