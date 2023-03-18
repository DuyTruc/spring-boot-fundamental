package fpt.m2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fpt.m2.entities.UserEntity;
import fpt.m2.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "User controller")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/{id}")
	public UserEntity getUser(@PathVariable("id") int id) {
		LOGGER.info("Find user by Id" + id);
		UserEntity ue = userService.getUserById(id);
		return ue;
	}
	
	@PostMapping(value = "")
	public UserEntity createUser(@Valid @RequestBody UserEntity user) {
		return userService.createUser(user);
	}
	
	@PutMapping(value = "")
	public UserEntity updateUser(@Valid @RequestBody UserEntity user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}
}
