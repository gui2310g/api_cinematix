package com.example.api_cinematix.controller;

import com.example.api_cinematix.domain.service.UserService;
import com.example.api_cinematix.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserRequest createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping
    public List<UserRequest> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserRequest findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
