package fpt.m2.FPT_AnhLD42.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import fpt.m2.FPT_AnhLD42.Entity.UserEntity;
import fpt.m2.FPT_AnhLD42.Service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	// creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/user")
	private ResponseEntity<List<UserEntity>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Integer id) {
		UserEntity user = userService.getUserById(id);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<Boolean> createUser(@RequestBody UserEntity user) {
		try {
			userService.createUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
    public UserEntity updateUser(@RequestBody UserEntity user) {
		UserEntity updateResponse = userService.updateUser(user);
        return updateResponse;
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Integer id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NO_CONTENT);
	}
}
