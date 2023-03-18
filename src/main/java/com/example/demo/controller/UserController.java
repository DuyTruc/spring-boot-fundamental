package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// Save operation
	@PostMapping("/users")
	public UserEntity saveUser(@Valid @RequestBody UserEntity user) {
		logger.debug("add user");
		return userService.saveUser(user);
	}

	// Read operation
	@GetMapping("/users")
	public List<UserEntity> fetchUserList() {
		logger.debug("get all user");
		return userService.fetchUserList();
	}

	// Read operation
	@GetMapping("/users/{id}")
	public UserEntity fetchUser(@PathVariable("id") Integer id) {
		logger.debug("get user");
		return userService.fetchUser(id);
	}

	// Update operation
	@PutMapping("/users/{id}")
	public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable("id") Integer id) {
		logger.debug("update user");
		return userService.updateUser(user, id);
	}

	// Delete operation
	@DeleteMapping("/users/{id}")
	public String deleteDepartmentById(@PathVariable("id") Integer id) {
		logger.debug("delete user");
		userService.deleteUserById(id);
		return "Deleted Successfully";
	}
}
