package com.example.HackatonByGreatDevelopers.repositories;


import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import com.example.HackatonByGreatDevelopers.entity.PatientCardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {

    PatientCard findByIin(String iin);
}
