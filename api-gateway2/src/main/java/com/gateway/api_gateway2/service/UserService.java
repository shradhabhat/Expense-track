package com.gateway.api_gateway2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.api_gateway2.entity.UserCredential;
import com.gateway.api_gateway2.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getIdByUsername(String username) {
        Optional<UserCredential> user = userRepository.findByUsername(username);
        return user.map(UserCredential::getId).orElse(null);
    }
}