package fpt.m2.tantcd.controller;

import fpt.m2.tantcd.entity.User;
import fpt.m2.tantcd.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public void create(@Validated @RequestBody User user) {
        service.create(user);
    }

    @GetMapping("/{userName}")
    public User getByName(@PathVariable String userName) {
        return service.getByName(userName);
    }

    @PutMapping
    public void update(@Validated @RequestBody User user) {
        service.update(user);
    }

    @DeleteMapping("/{userName}")
    public void delete(@PathVariable String userName) {
        service.delete(userName);
    }
}
