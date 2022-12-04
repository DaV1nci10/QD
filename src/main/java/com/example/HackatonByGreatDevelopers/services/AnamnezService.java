package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import com.example.HackatonByGreatDevelopers.model.Anamnez;
import com.example.HackatonByGreatDevelopers.repositories.AnamnezRepository;
import com.example.HackatonByGreatDevelopers.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnamnezService {
    private final AnamnezRepository anamnezRepository;
    private final PatientRepository patientRepository;

    public List<Anamnez> getAllByIin(String iin){
        Patient patient = patientRepository.findPatientByIin(iin);
        return anamnezRepository.findAllById(patient.getPatient_id());
    }

    public List<Anamnez> getAllAnamnezByName(String name){
        return anamnezRepository.findAnamnezByAnamnezName(name);
    }
}
