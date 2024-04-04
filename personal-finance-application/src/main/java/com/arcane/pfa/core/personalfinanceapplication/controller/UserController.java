package com.arcane.pfa.core.personalfinanceapplication.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arcane.pfa.core.personalfinanceapplication.model.LoginUserRequest;
import com.arcane.pfa.core.personalfinanceapplication.model.User;
import com.arcane.pfa.core.personalfinanceapplication.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*") 
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping 
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		if(newUser != null) {
			return ResponseEntity.ok(newUser);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Long userId){
		User newUser = userService.getUser(userId);
		if(userId != null) {
			return ResponseEntity.ok(newUser);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Long userId,  @RequestBody User user){
		if(userId != null) {
			user.setUserId(userId);
			User newUser = userService.updateUser(user);
			return ResponseEntity.ok(newUser);
		}
		return ResponseEntity.notFound().build();
	} 
	
	
	
	@PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginUserRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        Optional<User> user = Optional.of(userService.loginUser(email, password));
		if(user.isPresent()) {
			String sessionToken = UUID.randomUUID().toString();
			return ResponseEntity.ok(sessionToken);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Email or Password");
    }
	
	 @GetMapping("/inactive")
	    public ResponseEntity<List<User>> getInactiveUsers() {
	        List<User> inactiveUsers = userService.findInactiveUsers();
	        return ResponseEntity.ok(inactiveUsers);
	    }
}
