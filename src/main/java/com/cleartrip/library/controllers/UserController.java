package com.cleartrip.library.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cleartrip.library.entities.User;
import com.cleartrip.library.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService userService;

	// Get All Users
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	// Create a new User
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userService.save(user);
	}

	// Create a new User
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody User user) {
		userService.delete(user);
	}
}
