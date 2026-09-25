package com.portfolio.gateway;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {
    
    // Exactamente la MISMA llave que en auth-api
    private static final String SECRET_STRING = "4qhq8L6M/2Y7O5j+hQZf8H4pT3wW6y9XbG5sK1mN0pE=";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(io.jsonwebtoken.io.Decoders.BASE64.decode(SECRET_STRING));

    public void validateToken(String token) {
        Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
    }
}
