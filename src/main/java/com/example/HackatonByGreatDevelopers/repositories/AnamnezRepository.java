package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.entity.PatientCard;
import com.example.HackatonByGreatDevelopers.model.Anamnez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnamnezRepository extends JpaRepository<Anamnez, Long> {
//    List<AllergyAnamnez> findAllByPatientId(Long patientId);

    @Query(value = "select * from anamnezs a where a.patient_id=:id", nativeQuery = true)
    List<Anamnez> findAllById(@Param("id") Long id);


//    @Query(value = "select * from anamnezs a where a.patient_id=id", nativeQuery = true)
//    PatientCard getPatientCardById(@Param("id") Long id);
}
