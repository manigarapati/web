package com.arcane.pfa.core.personalfinancecoreaccountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinancecoreaccountservice.Repository.UserDetailsRepository;
import com.arcane.pfa.core.personalfinancecoreaccountservice.model.UserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@Override
	public UserDetails createUserDetails(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}

	@Override
	public UserDetails updateUserDetails(UserDetails userDetails) {
		if(getUserDetails(userDetails.getUserId()) != null) {
			getUserDetails(userDetails.getUserId());
			return userDetailsRepository.save(userDetails);
		}
		 return null;
	}

	@Override
	public UserDetails getUserDetails(Long userId) {
		
		return userDetailsRepository.findById(userId).get();
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