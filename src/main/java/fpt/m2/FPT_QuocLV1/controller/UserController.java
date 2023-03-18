package fpt.m2.FPT_QuocLV1.controller;

import fpt.m2.FPT_QuocLV1.dto.UserDto;
import fpt.m2.FPT_QuocLV1.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/user")
    public UserDto createUser(@RequestBody UserDto userDto){
        return userServiceImpl.createUser(userDto);
    }
    @GetMapping("/user/{id}")
    private UserDto getUserById(@PathVariable long id){
        return userServiceImpl.getUserById(id);
    }
    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable long id,@RequestBody UserDto userDto){
        userServiceImpl.updateUser(id,userDto);
    }
    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable long id){
        logger.debug("Debug delete user ");
        userServiceImpl.deleteUser(id);
    }

}
