package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Phrase;
import com.example.HackatonByGreatDevelopers.model.Article;
import com.example.HackatonByGreatDevelopers.services.PhraseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phrases")
public class PhraseController {

    private final PhraseService phraseService;

    //ЗАЧЕМ ??
    @PostMapping("/phrases")
    List<Phrase> getAllMatchesByPhrase(@RequestBody Article searchArticle) throws IOException {
        List<Phrase> result = new ArrayList<>();
        List<String> stringList = phraseService.searchForSuggestList(searchArticle.getText(), "documents");
        return result;
    }


}
