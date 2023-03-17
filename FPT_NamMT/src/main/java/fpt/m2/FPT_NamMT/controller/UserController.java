package fpt.m2.FPT_NamMT.controller;

import fpt.m2.FPT_NamMT.model.UserEntity;
import fpt.m2.FPT_NamMT.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class UserController {
  @Autowired
  private UserService userService;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @GetMapping("/getAll")
  public ResponseEntity<List<UserEntity>> getAllUser() {
    LOGGER.debug("Message logged at DEBUG level");
    List<UserEntity> listUser = userService.getAllUser();
    if (!CollectionUtils.isEmpty(listUser)) {
      return ResponseEntity.ok(listUser);
    }
    return new ResponseEntity("No User !!!", HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/createUser")
  public ResponseEntity<Void> createUser(@Validated @RequestBody UserEntity user) {
    LOGGER.debug("Message logged at DEBUG level");
    userService.createUser(user);
    return new ResponseEntity("Create User Succesfully !!!", HttpStatus.OK);
  }

  @GetMapping("/getUserByName/{userName}")
  public ResponseEntity<List<UserEntity>> getUserByName(@PathVariable String userName) {
    LOGGER.debug("Message logged at DEBUG level");
    List<UserEntity> listUser = userService.getUserByName(userName);
    if (!CollectionUtils.isEmpty(listUser)) {
      return ResponseEntity.ok(listUser);
    }
    return new ResponseEntity("Username not found !!!", HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/getUser/{id}")
  public ResponseEntity<UserEntity> getUserById(@PathVariable String id) {
    LOGGER.debug("Message logged at DEBUG level");
    UserEntity user;
    try {
      user = userService.getUserById(id);
      if (Objects.nonNull(user)) {
        return ResponseEntity.ok(user);
      }
    } catch (Exception ex) {
      return new ResponseEntity("User not found !!!", HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(user);
  }

  @PutMapping("/updateUser/{id}")
  public ResponseEntity<Void> updateUser(@PathVariable String id,
                                         @Validated @RequestBody UserEntity user) {
    LOGGER.debug("Message logged at DEBUG level");
    UserEntity userUpdate;
    try {
      userUpdate = userService.getUserById(id);
      if (Objects.nonNull(userUpdate)) {
        userUpdate.setUserName(user.getUserName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setAddress(user.getAddress());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userService.updateUser(userUpdate);
        return new ResponseEntity("Update User Succesfully", HttpStatus.OK);
      }
    } catch (Exception ex) {
      return new ResponseEntity("User not exist", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity("Update User Succesfully", HttpStatus.OK);
  }

  @DeleteMapping("/deleteUser/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable String id) {
    LOGGER.debug("Message logged at DEBUG level");
    UserEntity userDelete;
    try {
      userDelete = userService.getUserById(id);
      if (Objects.nonNull(userDelete)) {
        userService.deleteUser(userDelete);
        return new ResponseEntity("Delete User Succesfully", HttpStatus.OK);
      }
    } catch (Exception ex) {
      return new ResponseEntity("User not exist", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity("Delete User Succesfully", HttpStatus.OK);
  }
}
