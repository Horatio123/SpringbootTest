package com.baimahu.controller;

import com.baimahu.entity.User;
import com.baimahu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hellp jpa";
    }
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }
    
    @GetMapping("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
