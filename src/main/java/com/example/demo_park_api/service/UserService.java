package com.example.demo_park_api.service;
import org.springframework.stereotype.Service;

import com.example.demo_park_api.entity.User;
import com.example.demo_park_api.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    
    @Transactional
    public User salvar(User user) {
        return userRepository.save(user);
    }
}
