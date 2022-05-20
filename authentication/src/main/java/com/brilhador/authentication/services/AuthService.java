package com.brilhador.authentication.services;

import com.brilhador.authentication.configuration.security.JwtTokenUtil;
import com.brilhador.authentication.models.base.User;
import com.brilhador.authentication.models.dto.AuthTokens;
import com.brilhador.authentication.models.dto.TokenResponse;
import com.brilhador.authentication.models.dto.UserResponse;
import com.brilhador.authentication.models.dto.ValidationResponse;
import com.brilhador.authentication.repositories.UserRepository;

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

    public ValidationResponse validateToken(String token) {
        boolean valid = this.jwtTokenUtil.validateToken(token);
        ValidationResponse response = new ValidationResponse(valid, null);
        if (valid) {
            String email = this.jwtTokenUtil.getEmail(token);
            UserResponse user = this.userRepository
                .findByEmail(email)
                .get()
                .toUserResponse();

            if (user != null) response.setUser(user);
            else response.setValid(valid);
        }
        return response;
    }

    public TokenResponse refreshToken(String token) {
        boolean valid = this.jwtTokenUtil.validateToken(token);

        if (valid) {
            String email = this.jwtTokenUtil.getEmail(token);
            User user = this.userRepository.findByEmail(email).get();
            return new TokenResponse(this.generateTokens(user).getToken());
        }
        return new TokenResponse(null);
    }
}
