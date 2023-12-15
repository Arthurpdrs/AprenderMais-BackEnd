package br.com.AprenderMais.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import br.com.AprenderMais.model.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret; 
    
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
            .withIssuer("auth-api")
            .withSubject(user.getName())
            .withExpiresAt(genExpirationDate())
            .sign(algorithm);

        return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generation token", exception);
        }
    }

    public String validateToken(String token){
         try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
            .withIssuer("auth-api")
            .build()
            .verify(token)
            .getSubject();
        } catch (JWTCreationException exception) {
            return "";
        }
    }

    private Instant genExpirationDate(){
        LocalDateTime nowPlus2Hours = LocalDateTime.now().plusHours(2);
        Instant instant = nowPlus2Hours.toInstant(ZoneOffset.of("-03:00"));

        return instant;
    }
}
