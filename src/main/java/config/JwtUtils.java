package config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import security.UserDetailsImpl;

import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret = "eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY2ODkyMDQ1MCwiaWF0IjoxNjY4OTIwNDUwfQzGWSvQEYfRpcDcZyVl9vqttbhwgIMwfNGiXOBGWBKKB16gtnU6uGwxD9iirZpfrm0u061NRwdejTHw";

    private final int jwtExpirationMs = 86400000;

    public String generateJwtToken(Authentication authentication){

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public boolean validateJwtToken(String jwt){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(jwt);
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
