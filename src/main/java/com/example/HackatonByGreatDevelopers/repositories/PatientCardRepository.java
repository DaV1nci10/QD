package com.example.HackatonByGreatDevelopers.repositories;


import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {

    Optional<PatientCard> findByIin(String iin);
}
