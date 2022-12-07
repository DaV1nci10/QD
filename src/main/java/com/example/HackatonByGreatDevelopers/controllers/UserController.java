package com.example.HackatonByGreatDevelopers.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class UserController {

    @GetMapping("/getInfoAboutUser")
    public ResponseEntity<?> getInfoOfUser(){
        Integer userId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userId == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userId);
    }


}
