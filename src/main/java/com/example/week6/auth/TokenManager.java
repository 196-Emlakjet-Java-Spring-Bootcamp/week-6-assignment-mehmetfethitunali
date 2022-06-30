package com.example.week6.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenManager {

    private static final String secret = "week6-secret";
    private static final int validity = 1 * 60 * 1000;

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("fethi")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.ES256, secret)
                .compact();
    }

    public boolean tokenValidate(String token){
        if (getUsernameToken(token) != null && isExpired(token)){
            return true;
        }
        return false;

    }

    public String getUsernameToken(String token){
        Claims claims = getClaims(token);
        return claims.getSubject();
    }
    public boolean isExpired(String token){
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }


}
