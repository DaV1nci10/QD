package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;

import java.util.List;

@Data
public class SectionWithListOfStrings {
    private String sectionCode;
    private List<String> text;

    public SectionWithListOfStrings(String sectionCode, List<String> text) {
        this.sectionCode = sectionCode;
        this.text = text;
    }
}

