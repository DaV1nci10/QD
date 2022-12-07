package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.model.Article;
import com.example.HackatonByGreatDevelopers.repositories.ArticleRepository;
import com.example.HackatonByGreatDevelopers.services.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    @PostMapping("/save")
    @Operation(summary = "Сохранение артикля")
    public Article addArticle(@RequestBody Article article) {
        return articleService.saveOne(article);
    }

    @PostMapping("/saveList")
    @Operation(summary = "Сохранение множества артиклей")
    public List<Article> addArticle(@RequestBody List<Article> article) {
        return articleService.saveMany(article);
    }

    @PostMapping("/search")
    @Operation(summary = "Поиск всех фраз по секции")
    public List<Article> search(@RequestBody Article article) {
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
