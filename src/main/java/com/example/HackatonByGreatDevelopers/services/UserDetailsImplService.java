package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.config.Constants;
import com.example.HackatonByGreatDevelopers.entity.User;
import com.example.HackatonByGreatDevelopers.repositories.UserRepository;
import com.example.HackatonByGreatDevelopers.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsImplService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(Constants.USER_NAME_NOT_FOUND + username);
        }
        return UserDetailsImpl.build(user);
    }
}
