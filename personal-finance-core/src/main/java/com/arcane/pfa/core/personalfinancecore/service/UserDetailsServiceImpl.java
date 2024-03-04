package com.arcane.pfa.core.personalfinancecore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinancecore.Repository.UserDetailsRepository;
import com.arcane.pfa.core.personalfinancecore.dto.UserDetailsRespone;
import com.arcane.pfa.core.personalfinancecore.model.UserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails createUserDetails(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}
	
//	@Override
//    public UserDetails checkUserStatus(String email) {
//        UserDetails fetchedUserDetails = userDetailsRepository.findUserDetailsByEmail(email);
//
//        if (fetchedUserDetails==null){
//            throw new RuntimeException(String.format("UserDetails with email %s not found",email));
//        }
//        return fetchedUserDetails;
//    }

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
		return userDetailsRepository.findById(userId).orElse(null);
	}
	private UserDetailsRespone doToBo(UserDetails userDetails) {
		UserDetailsRespone userDetailsRespone = new UserDetailsRespone();
		userDetailsRespone.setName(userDetails.getName());
		userDetailsRespone.setUserAddress(userDetails.getUserAddress());
		userDetailsRespone.setUserEmail(userDetails.getUserEmail());
		userDetailsRespone.setUserId(userDetails.getUserId());
		userDetailsRespone.setUserName(userDetails.getUserName());
		userDetailsRespone.setUserPhoneNumber(userDetails.getUserPhoneNumber());
		return userDetailsRespone;
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