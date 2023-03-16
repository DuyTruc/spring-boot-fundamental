package fpt.m2.FPT_DucNN19;

import fpt.m2.FPT_DucNN19.entity.UserEntity;
import fpt.m2.FPT_DucNN19.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/user")
public class UserController {

  /**
   * The User service.
   */
  @Autowired
  UserService userService;

  /**
   * Create user.
   *
   * @param userEntity the user entity
   */
  @PostMapping("/createUser")
  public void createUser(@Validated @RequestBody UserEntity userEntity) {
    userService.createUserService(userEntity);
  }

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   */
  @GetMapping("/getUserById/{id}")
  public UserEntity getUserById(@PathVariable("id") Long id) {
    return userService.getUserService(id);
  }

  /**
   * Update user.
   *
   * @param id         the id
   * @param userEntity the user entity
   */
  @PutMapping("/updateUser/{id}")
  public void updateUser(@PathVariable("id") Long id,
                         @Validated @RequestBody UserEntity userEntity) {
    userService.updateUserService(id, userEntity);
  }

  /**
   * Delete user.
   *
   * @param id the id
   */
  @DeleteMapping("/deleteUser/{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    userService.deleteUserService(id);
  }
}
