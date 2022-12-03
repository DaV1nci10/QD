package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "patients")
public class Patient {
    @Id
    private Long patient_id;
    private String iin;

}
