package com.example.HackatonByGreatDevelopers.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.example.HackatonByGreatDevelopers.security.UserDetailsImpl;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class

JwtUtils {

    private final String jwtSecret = "esekretjknafsafngoiajgroaeigrjoszgasdokgawpora2swfqead";

    private final int jwtExpirationMs = 86400000;

    public String generateJwtToken(Authentication authentication){

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }

    public boolean validateJwtToken(String jwt){
        try{
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt)
                    .getBody();
            return true;
        } catch (MalformedJwtException | UnsupportedJwtException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public String getUserNameFromJwtToken(String jwt) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(jwt).getBody().getSubject();
    }


}
