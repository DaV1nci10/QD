package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;

import java.util.List;

@Data
public class Section {
    private String sectionCode;
    private List<Phrase> phraseList;

    public Section(String sectionCode, List<Phrase> phraseList) {
        this.sectionCode = sectionCode;
        this.phraseList = phraseList;
    }
}