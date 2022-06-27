package com.example.week6.controller;

import com.example.week6.entity.Users;
import com.example.week6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Users>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(){
        if (userService.createUser()){
            return new ResponseEntity("User Created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Not Created", HttpStatus.BAD_REQUEST);
        }
    }

}
