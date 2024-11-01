package com.example.demo_park_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_park_api.entity.User;

public interface UserRepository extends JpaRepository<User,  Long>{
    
}
