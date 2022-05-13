package com.brilhador.authentication.models.dto;

public class AuthTokens {
    UserResponse user;
    String token;
    String refreshToken;

    public AuthTokens(UserResponse user, String token, String refreshToken) {
        this.user = user;
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }    
}
