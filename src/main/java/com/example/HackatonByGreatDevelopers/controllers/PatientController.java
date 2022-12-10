package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import com.example.HackatonByGreatDevelopers.services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/save")
    @Operation(summary = "Добавление пациента")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @PostMapping("/save/several")
    @Operation(summary = "Добавление пациента")
    public List<Patient> saveSeveralPatients(@RequestBody List<Patient> patients){
        return patientService.saveSeveralPatients(patients);
    }

    @GetMapping("/all")
    @Operation(summary = "Получение всех пациентов")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
}
