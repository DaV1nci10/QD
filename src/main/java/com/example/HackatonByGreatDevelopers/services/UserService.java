package com.example.HackatonByGreatDevelopers.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public ResponseEntity<?> getInformationAboutUser(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userId == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userId);
    }
}
