package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import com.example.HackatonByGreatDevelopers.model.Anamnez;
import com.example.HackatonByGreatDevelopers.repositories.AnamnezRepository;
import com.example.HackatonByGreatDevelopers.repositories.PatientRepository;
import com.example.HackatonByGreatDevelopers.services.AnamnezService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anamnez")
@RequiredArgsConstructor
public class AnamnezController {

    private final AnamnezService anamnezService;

    @GetMapping("/{iin}")
    public List<Anamnez> getAllById(@PathVariable String iin){
        return anamnezService.getAllByIin(iin);
    }
}
