package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.model.Anamnez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnamnezRepository extends JpaRepository<Anamnez, Long> {

    @Query(value = "select * from anamnezs a where a.patient_id=:id", nativeQuery = true)
    List<Anamnez> findAllById(@Param("id") Long id);

    List<Anamnez> findAnamnezByAnamnezName(String name);

}
