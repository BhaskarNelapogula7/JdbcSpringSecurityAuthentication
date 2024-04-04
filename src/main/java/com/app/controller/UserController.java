package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.JdbcUserDetailsService;

@RestController
public class UserController {

    @Autowired
    private JdbcUserDetailsService jdbcUserDetailsService;

    @PostMapping("/user")
    public ResponseEntity<User> saveUserDetails(@RequestBody User user) {
        System.out.println(user);
        return new ResponseEntity<>(jdbcUserDetailsService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "This is a private endpoint";
    }
}
