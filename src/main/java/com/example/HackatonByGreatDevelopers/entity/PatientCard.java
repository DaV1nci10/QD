package com.example.HackatonByGreatDevelopers.entity;

import com.example.HackatonByGreatDevelopers.model.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "patient_cards")
public class PatientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;
    private String iin;
    private Date createdAt;
    private String fio;
    private String dob;
}
