package com.cleartrip.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleartrip.library.entities.User;
import com.cleartrip.library.repositories.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	public User find(String emailId){
		return userRepository.findAllByEmailId(emailId);
		
	}
	
	

}
