package com.arcane.pfa.core.repository;


import java.util.List;


import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.model.UserDetails;

public interface UserDetailsRepository  {
	  
	   
	  
	  public void save(UserDetails userdetails);
	  public UserDetails findById(Long userId);
	  public List<UserDetails> findAll();
	  public void deleteById(Long userId);
	  

}
