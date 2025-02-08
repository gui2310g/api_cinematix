package com.example.api_cinematix.controller;

import com.example.api_cinematix.domain.service.UserService;
import com.example.api_cinematix.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserRequest createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
