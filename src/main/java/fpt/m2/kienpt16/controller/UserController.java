package fpt.m2.kienpt16.controller;

import fpt.m2.kienpt16.entity.UserEntity;
import fpt.m2.kienpt16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserEntity user){

        userService.createUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> getUserByName(@RequestParam(name= "name") String name){

        List<UserEntity> userEntity = userService.getUserByName(name);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userEntity);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserEntity user){
        userService.updateUser(user);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){

        int userIdCv = Integer.parseInt(userId);

        userService.deleteUser(userIdCv);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }
}
