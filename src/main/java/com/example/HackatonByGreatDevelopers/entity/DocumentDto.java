package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;
import org.w3c.dom.Text;

import java.util.List;

@Data
public class DocumentDto {
    private String iin;
    private String fio;
    private String dob;
    private String doctor;
    private String dateOfCreation;
    private List<SectionBody> sections;
}
