package com.brilhador.authentication.services;

import java.util.UUID;

import com.brilhador.authentication.models.base.User;
import com.brilhador.authentication.models.exceptions.NotFound;
import com.brilhador.authentication.repositories.UserRepository;

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
