package com.arcane.pfa.core.repository;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.model.UserDetails;

@Repository
public class UserDetailsRepositoryImpl implements UserDetailsRepository {
	
	private long id = 1001;
	Map<Long,UserDetails> map = new HashMap<>();
	
	@Override
	public void save(UserDetails userDetails) {
		if(userDetails.getUserId() == null) {
			userDetails.setUserId(id);
			id++;
		}
		map.put(userDetails.getUserId(), userDetails);
		
	}

	@Override
	public UserDetails findById(Long userId) {
		
		return map.get(userId);
	}

	@Override
	public List<UserDetails> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<UserDetails>(map.values());
	}

	@Override
	public void deleteById(Long userId) {
		// TODO Auto-generated method stub
		map.remove(userId);
		
	}
	
	

}
