package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@Document(createIndex = true, indexName = "search")
public class SearchPatient {
    @Id
    private String id;
    private String iin;
    private String fio;
}
