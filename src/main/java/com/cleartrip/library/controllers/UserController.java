package com.cleartrip.library.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleartrip.library.entities.User;
import com.cleartrip.library.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;

	// Get All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	// Create a new User
	@PostMapping("/users")
	public User createNote(@Valid @RequestBody User user) {
	    return userService.save(user);
	}
}
