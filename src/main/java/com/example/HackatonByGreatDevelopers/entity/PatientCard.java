package com.example.HackatonByGreatDevelopers.entity;

import com.example.HackatonByGreatDevelopers.model.*;
import lombok.Data;

import java.util.List;

@Data
public class PatientCard {

    private Long patient_id;
    private String iin;
    private List<AllergyAnamnez> allergyAnamnezs;
    private List<Contraindications> contraindications;
    private List<FirstWatch> firstWatches;
    private List<IllAnamnez> illAnamnezs;
    private List<LifeAnamnez> lifeAnamnezs;
    private List<MainInfo> mainInfos;
}
