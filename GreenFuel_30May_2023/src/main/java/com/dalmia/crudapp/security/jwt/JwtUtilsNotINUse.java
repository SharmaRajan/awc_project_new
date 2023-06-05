package com.dalmia.crudapp.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtilsNotINUse {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtilsNotINUse.class);

    @Value("${simplecoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${simplecode.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    // Secret key used for signing and verifying JWTs
    private static final Key SECRET_KEY =  Keys.secretKeyFor(SignatureAlgorithm.HS512);

    // JWT expiration time (in milliseconds)
//    private static final long EXPIRATION_TIME = 900_000L; // 15 minutes

    // Generates a JWT token for the specified username
    public String generateToken(String username) {

        Date now = new Date();

//        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
        Date expiration = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SECRET_KEY)
                .compact();
    }

    // Validates and parses the specified JWT token, returning the username if the token is valid
    public String validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();

        }catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        } catch (Exception e) {
            // Token is invalid or has expired
//            return null;
            logger.error("JWT claims error: ", e.getMessage());
        }
        return  null;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }


}
