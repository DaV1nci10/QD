package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Document;
import com.example.HackatonByGreatDevelopers.entity.Phrase;
import com.example.HackatonByGreatDevelopers.model.Anamnez;
import com.example.HackatonByGreatDevelopers.model.Article;
import com.example.HackatonByGreatDevelopers.services.AnamnezService;
import com.example.HackatonByGreatDevelopers.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phrases")
public class PhraseController {

    private final RestHighLevelClient esClient;

    @PostMapping("/phrases")
    List<Phrase> getAllMatchesByPhrase(@RequestBody Article searchArticle) throws IOException {
        List<Phrase> result = new ArrayList<>();
        List<String> stringList = this.searchForSuggestList(searchArticle.getText(), "documents");
        return result;
    }

    public List<String> searchForSuggestList(String searchName, String index) throws IOException {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("text", searchName));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        List<String> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            list.add((String) sourceAsMap.get("text"));
        }
        return list;
    }
}
