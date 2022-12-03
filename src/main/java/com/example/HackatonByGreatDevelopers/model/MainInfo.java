package com.example.HackatonByGreatDevelopers.model;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "main_info")
public class MainInfo {
    @Id
    private Long id;
    private String bio;
    private String iin;
    private String dob;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient_id;
}
