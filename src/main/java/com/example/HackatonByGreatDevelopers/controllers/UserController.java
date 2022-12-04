package com.example.HackatonByGreatDevelopers.controllers;


import com.example.HackatonByGreatDevelopers.entity.User;
import com.example.HackatonByGreatDevelopers.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
