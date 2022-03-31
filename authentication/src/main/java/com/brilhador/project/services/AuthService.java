package com.brilhador.project.services;

import com.brilhador.project.configuration.security.JwtTokenUtil;
import com.brilhador.project.models.base.User;
import com.brilhador.project.models.dto.AuthTokens;
import com.brilhador.project.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthTokens generateTokens(User user){
        String token = jwtTokenUtil.generateToken(user);
        String refreshToken = jwtTokenUtil.generateRefreshToken(user);
        return new AuthTokens(user.toUserResponse(), token, refreshToken);
    }

    public User signUp(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
