package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.User;
import com.example.HackatonByGreatDevelopers.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository  userRepository;

    public ResponseEntity<?> getInformationAboutUser(){
        Integer userId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userId == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userId);
    }

    public User getAllByUserId(Long id){
        return userRepository.findAllById(id);

    }
}
