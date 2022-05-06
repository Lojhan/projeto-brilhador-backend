package com.brilhador.authentication.configuration.security;


import java.util.Date;

import com.brilhador.authentication.models.base.User;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.lang.String.format;

@Component
public class JwtTokenUtil {

    private final String jwtSecret = "brilhador";
    private final String jwtIssuer = "com.brilhador.project";


    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(format("%s,%s", user.getEmail(), user.getRole()))
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (3600 * 1000))) // 1 hour
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String generateRefreshToken(User user) {
        return Jwts.builder()
                .setSubject(format("%s,%s,%s,%s,%s", user.getEmail(), user.getName(), user.getId(), user.getRole(), user.getCpf()))
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (3600 * 1000) * 24 * 365)) // 1 year
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public String getEmail(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(jwtSecret)
            .parseClaimsJws(token)
            .getBody();
        return claims.getSubject().split(",")[0];
    }
}
