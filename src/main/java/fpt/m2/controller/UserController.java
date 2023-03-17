package fpt.m2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fpt.m2.entity.UserEntity;
import fpt.m2.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getUser/{id}")
	public UserEntity getUserById(@PathVariable("id") long id) {
		return userService.findById(id);
	}

	@PostMapping("/createUser")
	public void createUser(@Validated @RequestBody UserEntity userEntity) {
		userService.saveUser(userEntity);
	}

	@PutMapping("/updateUser")
	public void updateUser(@Validated @RequestBody UserEntity userEntity) {
		userService.saveUser(userEntity);
	}

	@GetMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
	}

}
