package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;
    private String iin;

}
