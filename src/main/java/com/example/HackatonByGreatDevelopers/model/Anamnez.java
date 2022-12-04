package com.example.HackatonByGreatDevelopers.model;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "anamnezs")
public class Anamnez {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String anamnezName;
    private String doctor;
    private boolean editable;
    private String content;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient_id;
}
