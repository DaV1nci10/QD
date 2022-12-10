package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAll();

    Optional<Patient> findPatientByIin(String iin);

    @Query(value = "select new com.example.HackatonByGreatDevelopers.entity.PatientCard " +
            "p.iin (patients.id, )", nativeQuery = true)
    PatientCard getPatientCardById();
}
