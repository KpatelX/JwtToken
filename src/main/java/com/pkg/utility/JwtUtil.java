package com.pkg.utility;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.pkg.constants.ServiceConstants.VALUE_SECRET_KEY;
import static com.pkg.constants.ServiceConstants.VALUE_SECRETE_EXPIRATION;

/**
 * The type Jwt util.
 */
@Component
public class JwtUtil {
    /**
     * The Token expiry time.
     */
    @Value(VALUE_SECRET_KEY)
    private String secretKey;

    /**
     * The Token expiry time.
     */
    @Value(VALUE_SECRETE_EXPIRATION)
    private long secreteExpiration;

    /**
     * Generate token string.
     *
     * @param username the username
     * @return the string
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + secreteExpiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * Validate token boolean.
     *
     * @param token the token
     * @return the boolean
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException jwtException) {
            return false;
        }
    }

    /**
     * Extract username string.
     *
     * @param token the token
     * @return the string
     */
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
