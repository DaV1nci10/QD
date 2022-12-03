package com.example.HackatonByGreatDevelopers.entity;

import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.Id;
import java.util.Date;

@org.springframework.data.elasticsearch.annotations.Document(createIndex = true, indexName = "documents")
@Data
public class Document {
    @Id
    private String id;
    private String iin;
    private String fio;
    private String dob;
    private String doctor;
    private Date dateOfCreation;
    private Text text;
}
