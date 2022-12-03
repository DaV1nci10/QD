package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "sections")
public class SectionBody {
    private String sectionCode;
    private String text;
}

