package com.cleartrip.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleartrip.library.entities.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User find(String emailId) {
		return userRepository.findAllByEmailId(emailId);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void update(User user) {
		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.delete(userRepository.findOne(id));
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public void delete(User user) {
		userRepository.delete(user);
		
	}
}
