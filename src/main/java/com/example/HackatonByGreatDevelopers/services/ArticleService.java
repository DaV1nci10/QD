package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.model.Article;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;
import com.example.HackatonByGreatDevelopers.repositories.ArticleRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final RestHighLevelClient esClient;

    public Article saveOne(Article article){
        return articleRepository.save(article);
    }

    public List<Article> saveMany(List<Article> article){
        for (int i = 0; i < article.size(); i++) {
            articleRepository.save(article.get(i));
        }
        return article;
    }

    public List<String> searchPhrasesByArticleName(String articleName) throws IOException {
        SearchRequest searchRequest = new SearchRequest("article");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(articleName, "title"));

        searchSourceBuilder.from(0);
        searchSourceBuilder.size(20);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        List<String> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()){
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            list.add((String) sourceAsMap.get("text"));
        }
        return list;
    }
}