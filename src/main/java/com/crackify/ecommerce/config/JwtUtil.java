package com.crackify.ecommerce.config;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
@Component
public class JwtUtil {
    @Value("${app.jwt.secret}")
    private String secretKey;

    @Value("${app.jwt.expiration}")
    private long exp;

    public String generateToken(String username,  Collection<? extends GrantedAuthority> authorities) {
        // Implementation for generating JWT token
        return Jwts.builder()
                .setSubject(username)
                .claim("role", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
                .compact();

    }

    public String extractUsername(String token) {
        // Implementation for extracting username from JWT token
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


    public boolean isValidToken(String token) {
        // Implementation for validating JWT token
        try{
            Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
