package com.brilhador.project.services;

import java.util.UUID;

import com.brilhador.project.models.base.User;
import com.brilhador.project.models.exceptions.NotFound;
import com.brilhador.project.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User getUser(UUID id) throws NotFound {
        return userRepository.findById(id).orElseThrow(() -> new NotFound("User"));
    }
}
