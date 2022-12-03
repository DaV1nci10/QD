package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    List<Article> findAllByTitle(String title);
    List<Article> findAll();
}
