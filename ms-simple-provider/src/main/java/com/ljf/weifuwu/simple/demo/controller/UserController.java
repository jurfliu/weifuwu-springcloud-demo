package com.ljf.weifuwu.simple.demo.controller;

import com.ljf.weifuwu.simple.demo.model.User;
import com.ljf.weifuwu.simple.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRespository userRepository;
    @GetMapping("/simpleuser/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.findOne(id);
    }
}
