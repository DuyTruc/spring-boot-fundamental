package fpt.m2.tantcd.controller;

import fpt.m2.tantcd.entity.User;
import fpt.m2.tantcd.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public void create(@RequestBody User user) {
        service.create(user);
    }

    @GetMapping
    public User getByName(@RequestParam String name) {
        return service.getByName(name);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @DeleteMapping("/{userName}")
    public void delete(@PathVariable String userName) {
        service.delete(userName);
    }
}
