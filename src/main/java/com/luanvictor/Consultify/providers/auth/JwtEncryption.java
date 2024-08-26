package com.luanvictor.Consultify.providers.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.luanvictor.Consultify.core.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtEncryption {
    @Value("${token}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("login-auth")
                    .withSubject(user.getId().toString())
                    .withExpiresAt(this.generateTokenExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating JWT token");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("login-auth")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private Instant generateTokenExpirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of(("-3")));
    }
}
