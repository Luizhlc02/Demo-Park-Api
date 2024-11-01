package com.example.demo_park_api.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_park_api.entity.User;
import com.example.demo_park_api.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    
    @Transactional
    public User salvar(User user) {
        return userRepository.save(user);
    }
    @Transactional(readOnly = true)
    public User buscarPorID(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }
}
