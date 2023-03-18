package com.fpt.m2.controllers;

import org.modelmapper.ModelMapper;
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
import com.fpt.m2.dto.UserRequestDTO;
import com.fpt.m2.dto.UserResponseDTO;
import com.fpt.m2.request.UserRequestBody;
import com.fpt.m2.response.UserResponseBody;
import com.fpt.m2.services.UserService;
import jakarta.validation.Valid;

@RestController

public class UserController {

	@Autowired
	private UserService userService;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	ModelMapper mapper = new ModelMapper();
	UserResponseDTO userResponseDTO = new UserResponseDTO();
	UserRequestDTO userRequestDTO = new UserRequestDTO();
	UserResponseBody userResponseBody = new UserResponseBody();

	// find user by id
	@GetMapping("/users/{id}")
	public UserResponseBody getUserById(@PathVariable("id") int id) {
		userResponseDTO = userService.getUserById(id);
		log.debug("Get user data!!!");
		// convert data response and return
		userResponseBody = mapper.map(userResponseDTO, UserResponseBody.class);
		return userResponseBody;
	}

	// insert user
	@PostMapping("/users")
	public UserResponseBody createUser(@Valid @RequestBody UserRequestBody userRequestBody) {
		// convert data input from model to dto
		userRequestDTO = mapper.map(userRequestBody, UserRequestDTO.class);
		userResponseDTO = userService.createUser(userRequestDTO);
		log.debug("Insert user data!!!");
		// convert data response and return
		userResponseBody = mapper.map(userResponseDTO, UserResponseBody.class);
		return userResponseBody;
	}

	// update user
	@PutMapping("/users")
	public UserResponseBody updateUser(@Valid @RequestBody UserRequestBody userRequestBody) {
		// convert data input from model to dto
		userRequestDTO = mapper.map(userRequestBody, UserRequestDTO.class);
		userResponseDTO = userService.updateUser(userRequestDTO);
		log.debug("Update user data");
		// convert data response and return
		userResponseBody = mapper.map(userResponseDTO, UserResponseBody.class);
		return userResponseBody;
	}

	// delete user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		log.debug("Delete user data");
	}

}
