package com.arcane.pfa.core.personalfinanceapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.arcane.pfa.core.personalfinanceapplication.exception.UserNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.model.User;
import com.arcane.pfa.core.personalfinanceapplication.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	private User user;
	
	@BeforeEach
	void setUp() {
		user = User.builder()
				.userId(1L)
				.email("manigarapati@gmail.com")
				.password("AZaz-0$$")
				.firstName("Mani")
				.lastName("Garapati")
				.dateJoined(LocalDate.of(2024, 02, 21))
				.build();
	}
	
	@Test
	public void givenUserObject_whenSaveUser_thenReturnUserObject() {
		BDDMockito.given(userRepository.save(user)).willReturn(user);
		User savedUser = userService.createUser(user);
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getFirstName()).isEqualTo(user.getFirstName());
	}
	
	@Test 
	@DisplayName("Junit test for getUser Method")
	public void givenUserId_whenGetUser_thenReturnUserObject() {
		Long userId = 1L;
		BDDMockito.given(userRepository.findById(userId)).willReturn(Optional.of(user));
		User retrivedUser = userService.getUser(userId);
		assertThat(retrivedUser).isNotNull();
		assertThat(retrivedUser.getFirstName()).isEqualTo(user.getFirstName());
	}
	
	@Test 
	@DisplayName("Junit test for getUser method - Invalid UserId  ")
	public void givenWrongUserId_whenGetUser_thenThrowsException() {
		Long userId = 12L;
		BDDMockito.given(userRepository.findById(userId)).willReturn(Optional.empty());
		Exception exception =assertThrows(UserNotFoundException.class, ()->{userService.getUser(userId);});
		assertThat(exception.getMessage()).isEqualTo("Requested User does not exist !!!");
	}
	
	@Test
	@DisplayName("Junit test for UpdateUser method")
	public void givenUserObject_whenUpdateUser_willReturnUserObject() {
		Long userId = user.getUserId();
		BDDMockito.given(userRepository.findById(userId)).willReturn(Optional.of(user));
		User userUpdate = new User();
		userUpdate.setUserId(1L);
		userUpdate.setEmail("updatedemail@example.com");
		userUpdate.setPassword("updatedPassword");
		BDDMockito.given(userRepository.save(userUpdate)).willReturn(userUpdate);
		User updatedUser = userService.updateUser(userUpdate);
		assertThat(updatedUser).isNotNull();
		assertThat(updatedUser.getEmail()).isEqualTo(userUpdate.getEmail());
		assertThat(updatedUser.getPassword()).isEqualTo(userUpdate.getPassword());
	}
	
	@Test
	@DisplayName("Junit test for UpdateUser method-Invalid User")
	public void givenWrongUserObject_whenUpdateUser_willReturnUserObject() {
		User user = new User();
		user.setUserId(12L);
		Long userId= user.getUserId();
		BDDMockito.given(userRepository.findById(userId)).willReturn(Optional.empty());
		Exception exception = assertThrows(UserNotFoundException.class, ()->{userService.updateUser(user);});
		assertThat(exception.getMessage()).isEqualTo("Requested User does not exist !!!");
	}
	
	@Test
	@DisplayName("Junit test for LoginUser Method")
	public void givenLoginCredentials_whenLoginUser_willReturnUserObject() {
		String email = "manigarapati@gmail.com";
		String password = "AZaz-0$$";
		when(userRepository.findByEmailAndPassword(email, password)).thenReturn(user);
		User loginUser = userService.loginUser(email, password);
		assertThat(loginUser).isNotNull();
		assertThat(loginUser).isEqualTo(user);
		assertThat(loginUser.getDateJoined()).isEqualTo(user.getDateJoined());
	}
	
	@Test
	@DisplayName("Junit test for LoginUser Method- Invalid User")
	public void givenWrongLoginCredentials_whenLoginUser_willReturnUserObject() {
		String email = "mani@gmail.com";
		String password = "AZaz-0$$";
		when(userRepository.findByEmailAndPassword(email, password)).thenReturn(null);
		Exception exception = assertThrows(UserNotFoundException.class, ()->{userService.loginUser(email, password);});
		assertThat(exception.getMessage()).isEqualTo("Invalid UserName or Password");
	}
	
	
	
	
	
	

}
