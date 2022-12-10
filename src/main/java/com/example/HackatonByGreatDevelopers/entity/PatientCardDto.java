package com.example.HackatonByGreatDevelopers.entity;

import com.example.HackatonByGreatDevelopers.model.Anamnez;
import lombok.Data;

import java.util.List;

@Data
public class PatientCardDto {
    PatientCard patientCard;
    List<Document> documents;
}
