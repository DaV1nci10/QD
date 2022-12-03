package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.entity.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends ElasticsearchRepository<Document, String> {
}
