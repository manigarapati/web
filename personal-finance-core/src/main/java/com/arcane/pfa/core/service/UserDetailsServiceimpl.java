package com.arcane.pfa.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.model.UserDetails;
import com.arcane.pfa.core.repository.UserDetailsRepository;
@Service
public class UserDetailsServiceimpl implements UserDetailsService {
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public String createUserDetails(UserDetails userDetails) {
		userDetailsRepository.save(userDetails);
		return "Success";
	}

	@Override
	public String updateUserDetails(UserDetails userDetails) {
		if(getUserDetails(userDetails.getUserId()) != null) {
			getUserDetails(userDetails.getUserId());
			userDetailsRepository.save(userDetails);
			return "Success";
		}
		 return "User not found to Update";
	}

	@Override
	public UserDetails getUserDetails(Long userId) {
		
		return userDetailsRepository.findById(userId);
	}

	@Override
	public List<UserDetails> getAllUserDetails() {
		// TODO Auto-generated method stub
		return userDetailsRepository.findAll();
	}

	@Override
	public String deleteUserDetails(Long userId) {
		// TODO Auto-generated method stub
		if(getUserDetails(userId) != null) {
			userDetailsRepository.deleteById(userId);
			return "User deleted Successfully!!!";
		}
		return "User not found to delete";
	}

}
