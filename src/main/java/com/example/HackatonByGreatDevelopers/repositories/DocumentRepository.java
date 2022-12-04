package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.entity.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends ElasticsearchRepository<Document, String> {

    List<Document> getDocumentsByIin(String iin);
}
