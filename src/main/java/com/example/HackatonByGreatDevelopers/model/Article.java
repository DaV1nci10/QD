package com.example.HackatonByGreatDevelopers.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(createIndex = true, indexName = "article")
public class Article {
    @Id
    private String id;
    private String title;
    private String text;
}
