package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import com.example.HackatonByGreatDevelopers.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient savePatient(Patient patient){
        Optional<Patient> testPatient = patientRepository.findPatientByIin(patient.getIin());
        if (testPatient.isPresent())
            return patient;
        return patientRepository.save(patient);
    }

    public List<Patient> saveSeveralPatients(List<Patient> patients){
        List<Patient> savedPatients = new ArrayList<>();
        for (int i = 0; i < patients.size(); i++)
            savedPatients.add(savePatient(patients.get(i)));
        return savedPatients;
    }


    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
}
