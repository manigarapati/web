package com.arcane.pfa.core.personalfinanceapplication.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.arcane.pfa.core.personalfinanceapplication.model.User;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	private User user;
	
	@BeforeEach
	void setUp() {
//		user = new User(1L, "manikantagarapati007@gmail.com", "AZaz09$$", "Manikanta", 
//							"Garapati", LocalDate.of(2024, 02, 21) );
	}
	
	@AfterEach
	void tearDown() {
		user = null;
		userRepository.deleteAll();
	}
	
	@Test
	void testFindByEmailAndPassword_Found() {
			userRepository.save(user);
		User user1 = userRepository.findByEmailAndPassword("manikantagarapati007@gmail.com", "AZaz09$$");
		assertThat(user1).isNotNull();
		assertThat(user1.getUserId()).isEqualTo(user.getUserId());
		assertThat(user1.getFirstName()).isEqualTo(user.getFirstName());
	}
	
	

}
