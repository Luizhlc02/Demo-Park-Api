package com.example.demo_park_api.web_controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/{id}")
    public ResponseEntity<User> getByID(@PathVariable Long id){   
    User usuario = userService.buscarPorID(id); 
    return ResponseEntity.ok(usuario);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable Long id, @RequestBody User user){   
    User usuario = userService.editarSenha(id, user.getPassword()); 
    return ResponseEntity.ok(usuario);
    }
}
