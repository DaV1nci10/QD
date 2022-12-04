package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import com.example.HackatonByGreatDevelopers.entity.PatientCardDto;
import com.example.HackatonByGreatDevelopers.repositories.AnamnezRepository;
import com.example.HackatonByGreatDevelopers.repositories.PatientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientCardService {

    private final PatientCardRepository patientCardRepository;
    private final AnamnezService anamnezService;

    public PatientCard savePatientCard(PatientCard patientCard){
        return patientCardRepository.save(patientCard);
    }

    public boolean isPatientCard(PatientCard patientCard){
        if (patientCardRepository.findByIin(patientCard.getIin()) != null)
            return true;
        return false;
    }

    public PatientCardDto getPatientCardDto(String iin){
        PatientCardDto patientCardDto = new PatientCardDto();
        patientCardDto.setPatientCard(patientCardRepository.findByIin(iin));
        patientCardDto.setAnamnezs(anamnezService.getAllByIin(iin));
        return patientCardDto;
    }

    public PatientCard findByIin(String iin){
        return patientCardRepository.findByIin(iin);
    }
}
