package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/a")
public class ControllerTest {

    private final UserService userService;

    @GetMapping("/getInfoAboutUser")
    public ResponseEntity<?> getInfoOfUser(){
        return userService.getInformationAboutUser();
    }
}
