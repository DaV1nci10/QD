package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;

import java.util.List;

@Data
public class Phrase {
    private String original;
    private boolean isFullMatched;
    private List<String> suggest;
    private boolean isDelimiter;

    public Phrase(String original, boolean isFullMatched, List<String> suggest, boolean isDelimiter) {
        this.original = original;
        this.isFullMatched = isFullMatched;
        this.suggest = suggest;
        this.isDelimiter = isDelimiter;
    }
}
