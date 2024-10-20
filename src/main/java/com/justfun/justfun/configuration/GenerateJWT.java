package com.justfun.justfun.configuration;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class GenerateJWT {
    public String generateJWT(Authentication authentication){
        String username = authentication.getName();
        Date creationDate = new Date();
        Date expireDate = new Date(creationDate.getTime() + SecurityConstant.JWT_EXPIRY);
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String token = Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key)
//                .signWith(SignatureAlgorithm.HS512, SecurityConstant.JWT_SECRETE)
                .compact();

        System.out.println("New TOKEN: "+token);
        return token;
    }

    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstant.JWT_SECRETE).build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SecurityConstant.JWT_SECRETE).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Token was expired or invalid");
        }
    }
}
