package com.example.HackatonByGreatDevelopers.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allergy")
public class AllergyAnamnezController {

    @GetMapping
    public String str(){
        return "stt";
    }
}
