package com.arcane.pfa.core.personalfinancecoreaccountservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinancecoreaccountservice.model.UserDetails;
import com.arcane.pfa.core.personalfinancecoreaccountservice.service.UserDetailsService;



@RestController
@RequestMapping("/userdetails")
public class UserDetailsController {
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/{userId}")
	public UserDetails getUserDetails(@PathVariable("userId") Long userId) {
		return userDetailsService.getUserDetails(userId);
	}
	@GetMapping
	public List<UserDetails> getAllUserDetails() {
		return userDetailsService.getAllUserDetails();
	}
	
	@PostMapping
	public UserDetails createUserDetails(@RequestBody UserDetails userDetails) {
		
		return userDetailsService.createUserDetails(userDetails);
	}
	@PutMapping
	public UserDetails updateUserDetails(@RequestBody UserDetails userDetails) {
		
		return userDetailsService.updateUserDetails(userDetails);
		
	}
	@DeleteMapping("/{userId}")
	public String deleteUserDetails(@PathVariable("userId") Long userId) {
		return userDetailsService.deleteUserDetails(userId);
	}

}

