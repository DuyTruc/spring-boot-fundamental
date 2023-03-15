package fpt.m2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fpt.m2.common.constants.MessageConstant;
import fpt.m2.common.helpers.HelperBuilder;
import fpt.m2.entities.UserEntity;
import fpt.m2.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping()
	public ResponseEntity<?> createUser(@Valid @RequestBody UserEntity user) {
            
		 userService.createUser(user);
		return ResponseEntity.ok(HelperBuilder.buildMessage(MessageConstant.M1));
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getUserByName(@Valid @PathVariable("name")String name) {
		 List<UserEntity> userResult = userService.getUserByName(name);
		return ResponseEntity.ok(userResult);
	}
	
	@PutMapping()
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserEntity user) {
		userService.updateUser(user);
		return ResponseEntity.ok(HelperBuilder.buildMessage(MessageConstant.M2));
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<?> delteUser(@Valid @PathVariable("email")String email) {
		userService.deleteUser(email);
		return ResponseEntity.ok(HelperBuilder.buildMessage(MessageConstant.M3));
	}
}
