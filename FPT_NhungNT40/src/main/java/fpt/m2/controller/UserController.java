package fpt.m2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fpt.m2.entity.UserEntity;
import fpt.m2.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		List<UserEntity> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
		UserEntity user = userService.createUser(userEntity);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("user/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
		UserEntity user = userService.getUserById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserEntity userEntity) {
		UserEntity user = userService.getUserById(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		UserEntity newUser = userService.updateUser(id, userEntity);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		UserEntity user = userService.getUserById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

}
