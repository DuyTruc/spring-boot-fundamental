package fpt.m2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fpt.m2.entities.User;
import fpt.m2.repos.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<User> getUsers() {
		return repository.findAll();
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public User createUser(@Validated @RequestBody User user) {
		return repository.save(user);
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}
