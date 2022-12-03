package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.model.AllergyAnamnez;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllergyAnamnezRepository extends JpaRepository<AllergyAnamnez, Long> {
//    List<AllergyAnamnez> findAllByPatient_id(Long patientId);
}
