package br.com.memogame.game.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {
    @Value("${secret}")
    private String SECRET;

    public String generateToken(String username) {
        try {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 60000 * 60))
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact();
        } catch (Exception e) {
            System.out.println("Erro ao gerar JWT" + e);
            return null;
        }
    }

    public Claims validateToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            throw new RuntimeException("JWT inválido");
        }
    }
}