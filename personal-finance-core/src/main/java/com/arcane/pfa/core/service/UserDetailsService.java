package com.arcane.pfa.core.service;

import java.util.List;

import com.arcane.pfa.core.model.UserDetails;

public interface UserDetailsService {
	public String createUserDetails(UserDetails userDetails);
	public String updateUserDetails(UserDetails userDetails);
	public UserDetails getUserDetails(Long userId);
	public List<UserDetails> getAllUserDetails();
	public String deleteUserDetails(Long userId);

}
