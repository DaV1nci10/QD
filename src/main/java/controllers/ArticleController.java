package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import services.ArticleService;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ArticleController {

    private final ArticleService articleService;

    @PutMapping("/articles")
    public String addArticle(@RequestParam ("title") String title, @RequestParam("text") String text) throws IOException {
        String id = UUID.randomUUID().toString();
        articleService.updateArticle(id, title, text);
        return id;
    }
}
