package com.example.HackatonByGreatDevelopers.model;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ill_anamnez")
public class IllAnamnez {
    @Id
    private Long id;
    private String doctor;
    private boolean editable;
    private String content;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient_id;
}
