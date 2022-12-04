package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import com.example.HackatonByGreatDevelopers.entity.PatientCardDto;
import com.example.HackatonByGreatDevelopers.entity.SearchPatient;
import com.example.HackatonByGreatDevelopers.repositories.PatientCardRepository;
import com.example.HackatonByGreatDevelopers.repositories.SearchPatientDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientCardService {

    private final PatientCardRepository patientCardRepository;
    private final AnamnezService anamnezService;
    private final SearchPatientDtoRepository searchPatientDtoRepository;

    public PatientCard savePatientCard(PatientCard patientCard){
        SearchPatient patientDto = new SearchPatient();
        patientDto.setFio(patientCard.getFio());
        patientDto.setIin(patientCard.getIin());
        searchPatientDtoRepository.save(patientDto);
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
