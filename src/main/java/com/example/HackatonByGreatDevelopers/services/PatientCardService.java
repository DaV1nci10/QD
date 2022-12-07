package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import com.example.HackatonByGreatDevelopers.entity.PatientCardDto;
import com.example.HackatonByGreatDevelopers.entity.SearchPatient;
import com.example.HackatonByGreatDevelopers.repositories.PatientCardRepository;
import com.example.HackatonByGreatDevelopers.repositories.SearchPatientDtoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientCardService {

    private final PatientCardRepository patientCardRepository;
    private final AnamnezService anamnezService;
    private final SearchPatientDtoRepository searchPatientDtoRepository;

    public PatientCard savePatientCard(PatientCard patientCard) throws Exception {
        SearchPatient patientDto = new SearchPatient();
//        patientCardRepository.findByIin(patientCard.getIin()).orElseThrow(()->new Exception("allready exist"));
        patientDto.setFio(patientCard.getFio());
        patientDto.setIin(patientCard.getIin());
        searchPatientDtoRepository.save(patientDto);
        return patientCardRepository.save(patientCard);
    }

    public boolean isPatientCard(PatientCard patientCard) throws Exception {
        patientCardRepository.findByIin(patientCard.getIin()).orElseThrow(()->new Exception("allready exist"));
        return true;
    }

    public PatientCardDto getPatientCardDto(String iin) throws Exception {
        PatientCardDto patientCardDto = new PatientCardDto();
        PatientCard patientCard = patientCardRepository.findByIin(iin).orElseThrow(()->new Exception("no such PatientCard"));
        patientCardDto.setPatientCard(patientCard);
        patientCardDto.setAnamnezs(anamnezService.getAllByIin(iin));
        return patientCardDto;
    }

    public Optional<PatientCard> findByIin(String iin){
        return patientCardRepository.findByIin(iin);
    }

}
