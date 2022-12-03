package com.example.HackatonByGreatDevelopers.security;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;

    private String type = "bearer";

    private Long user_id;

    private String username;

    private String email;

    private List<String> roles;

    public JwtResponse(String token, Long user_id, String username, String email, List<String> roles) {
        this.token = token;
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
