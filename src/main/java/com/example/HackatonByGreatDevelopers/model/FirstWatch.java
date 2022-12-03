package com.example.HackatonByGreatDevelopers.model;

import com.example.HackatonByGreatDevelopers.entity.Patient;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "frist_watch")
public class FirstWatch {
    @Id
    private Long id;
    private String doctor;
    private boolean editable;
    private String content;
    private String publicationDate;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient_id;
}
