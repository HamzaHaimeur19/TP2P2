package com.example.jpaex2.controllers;

import com.example.jpaex2.entities.User;
import com.example.jpaex2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}") // chemin pour chercher utilisateur avec paramètre username
    public User user(@PathVariable String username) {
        User user = userService.findUserByUserName(username);
        return user;

    }
}
