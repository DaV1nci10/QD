package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.HackatonByGreatDevelopers.repositories.ArticleRepository;
import com.example.HackatonByGreatDevelopers.services.ArticleService;
import com.example.HackatonByGreatDevelopers.services.TestService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final TestService testService;
    private final ArticleRepository articleRepository;

    @PostMapping("/save")
    public Article addArticle(@RequestBody Article article) throws IOException {
        return articleService.saveOne(article);
    }

    @PostMapping("/search")
    public List<Article> search(@RequestBody Article article) throws IOException{
        return articleRepository.findAllByTitle(article.getTitle());
    }

//    @GetMapping("/getAllArticles")
//    public List<Article> getAllArticles() throws IOException{
//        List<Article> allArticles = articleRepository.findAll();
//        List<String> list = new ArrayList<>();
//        return allArticles;
//    }

//    @PostMapping("/search")
//    public List<Article> search(@RequestBody Article article) throws IOException{
//        return articleService.searchPhrasesByArticle(article.getTitle(), article.getText());
//    }
}
