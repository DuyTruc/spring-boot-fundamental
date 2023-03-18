package fpt.m2.FPT_HoangDQ2.controller;

import fpt.m2.FPT_HoangDQ2.model.User;
import fpt.m2.FPT_HoangDQ2.model.UserDTO;
import fpt.m2.FPT_HoangDQ2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = convertDTOToUser(userDTO);
        return convertUserToDTO(userService.create(user));
    }

    @PutMapping
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {
        User user = convertDTOToUser(userDTO);
        return convertUserToDTO(userService.save(user));
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable long userId) {
        User user = null;
        try {
            user = userService.findById(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return convertUserToDTO(user);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteById(userId);
    }

    private static UserDTO convertUserToDTO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    private User convertDTOToUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
