package com.arcane.pfa.core.personalfinanceapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinanceapplication.exception.UserNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.model.User;
import com.arcane.pfa.core.personalfinanceapplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long userId) {
		if (userRepository.findById(userId).isEmpty()) {
			throw new UserNotFoundException("Requested User does not exist !!!");

		}
		return userRepository.findById(userId).get();

	}

	@Override
	public User updateUser(User user) {
		if (getUser(user.getUserId()) == null) {
			throw new UserNotFoundException("Requested User does not exist to Update !!!");
		}
		return userRepository.save(user);
	}

	@Override
	public User loginUser(String email, String Password) {
		if (userRepository.findByEmailAndPassword(email, Password) == null) {
			throw new UserNotFoundException("Invalid UserName or Password");
		}
		return userRepository.findByEmailAndPassword(email, Password);

	}

}
