package com.example.demo_park_api.web_controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_park_api.entity.User;
import com.example.demo_park_api.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@RestController
public class UserController {
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){   
    User usuario = userService.salvar(user); 
    return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
