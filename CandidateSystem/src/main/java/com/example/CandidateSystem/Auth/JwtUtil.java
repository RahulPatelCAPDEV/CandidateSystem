package com.example.CandidateSystem.Auth;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


@Component
public class JwtUtil {



    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 3600000; // 1 hour

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }


    public String validateToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key) // key should be a SecretKey or byte[]
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            return null;
        }
    }


}
