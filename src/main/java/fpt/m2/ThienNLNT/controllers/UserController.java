package fpt.m2.ThienNLNT.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fpt.m2.ThienNLNT.entities.UserEntity;
import fpt.m2.ThienNLNT.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<UserEntity> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public Optional<UserEntity> getUser(@Validated @PathVariable("id") int id) {
		LOGGER.info("Finding product by ID:"+id);
		return userService.getById(id);
	}

	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public UserEntity createProduct(@Validated @RequestBody UserEntity userEntity) {
		return userService.saveEntity(userEntity);
	}

	@RequestMapping(value = "/users/", method = RequestMethod.PUT)
	public UserEntity updateProduct(@Validated @RequestBody UserEntity userEntity) {
		return userService.updateUserEntity(userEntity);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@Validated @PathVariable("id") int id) {
		userService.deleteById(id);
	}
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public List<UserEntity> findAllByUserName(@Validated @PathVariable("username") String username) {
		return userService.findAllByUserName(username);
	}
}
