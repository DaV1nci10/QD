package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.*;
import com.example.HackatonByGreatDevelopers.services.TestService;
import com.example.HackatonByGreatDevelopers.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/firstTest")
@RequiredArgsConstructor
public class TestForMaks {

    @Autowired
    private UserService userService;
    private final RestHighLevelClient esClient;

    @GetMapping("getAllByUserId/{id}")
    public User getAllById(@PathVariable Long id){
        return userService.getAllByUserId(id);
    }

    @Operation(summary = "Умный поиск всех пациентов по ИИН. В поисковом поле отображение автозаполнения")
    @PostMapping("/search")
    List<SearchPatient> getPatientsSearch(@RequestBody MyString str) throws IOException {
        return getSearchPatients(str.getSearchName(), "search");
    }

    public List<SearchPatient> getSearchPatients(String searchName, String index) throws IOException {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.boolQuery().should(new WildcardQueryBuilder("iin", searchName + "*")));


        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        List<SearchPatient> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            SearchPatient patient = new SearchPatient();
            patient.setFio((String)sourceAsMap.get("fio"));
            patient.setIin((String) sourceAsMap.get("iin"));
            list.add(patient);
        }
        return list;
    }
}
