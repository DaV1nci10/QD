package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import com.example.HackatonByGreatDevelopers.entity.PatientCardDto;
import com.example.HackatonByGreatDevelopers.services.PatientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("test/patientCard")
public class PatientCardController {

    private final PatientCardService patientCardService;

    @PostMapping("/save")
    PatientCard savePatientCard(@RequestBody PatientCard patientCard){
        if (patientCardService.isPatientCard(patientCard))
             return patientCardService.findByIin(patientCard.getIin());
        return patientCardService.savePatientCard(patientCard);
    }

    @GetMapping("/getPatientCardDto/{iin}")
    PatientCardDto getPatientCardDto(@PathVariable String iin){
        return patientCardService.getPatientCardDto(iin);
    }

}
