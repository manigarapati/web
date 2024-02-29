package com.arcane.pfa.core.personalfinanceapplication.service;

import java.util.List;

import com.arcane.pfa.core.personalfinanceapplication.model.LoginUserRequest;
import com.arcane.pfa.core.personalfinanceapplication.model.User;

public interface UserService {
	User createUser(User user);
	User getUser(Long userId);
	User updateUser(User user);
	User loginUser(String email, String Password);
	
	List<User> findInactiveUsers();
}
