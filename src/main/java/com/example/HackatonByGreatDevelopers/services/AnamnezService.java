package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import com.example.HackatonByGreatDevelopers.model.Anamnez;
import com.example.HackatonByGreatDevelopers.repositories.AnamnezRepository;
import com.example.HackatonByGreatDevelopers.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnamnezService {
    private final AnamnezRepository anamnezRepository;
    private final PatientRepository patientRepository;

    public List<Anamnez> getAllByIin(String iin){
        Optional<Patient> patient = patientRepository.findPatientByIin(iin);
        if (!patient.isPresent())
            return new ArrayList<>();
        return anamnezRepository.findAllById(patient.get().getPatient_id());
    }

    public List<Anamnez> getAllAnamnezByName(String name){
        return anamnezRepository.findAnamnezByAnamnezName(name);
    }
}
