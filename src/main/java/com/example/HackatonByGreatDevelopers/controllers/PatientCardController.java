package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import com.example.HackatonByGreatDevelopers.entity.PatientCardDto;
import com.example.HackatonByGreatDevelopers.services.PatientCardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("test/patientCard")
public class PatientCardController {

    private final PatientCardService patientCardService;

    @PostMapping("/save")
    @Operation(summary = "Сохранение/Создание новой карточки пациента")
    Optional<PatientCard> savePatientCard(@RequestBody PatientCard patientCard) throws Exception {
        patientCardService.savePatientCard(patientCard);
        return patientCardService.findByIin(patientCard.getIin());
    }

    @GetMapping("/getPatientCardDto/{iin}")
    @Operation(summary = "Получение карточки пациента на основании ИИН пациента")
    PatientCardDto getPatientCardDto(@PathVariable String iin) throws Exception {
        return patientCardService.getPatientCardDto(iin);
    }

}
