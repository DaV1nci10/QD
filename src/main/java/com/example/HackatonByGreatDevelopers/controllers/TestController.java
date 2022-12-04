package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.MyString;
import com.example.HackatonByGreatDevelopers.entity.SearchPatient;
import com.example.HackatonByGreatDevelopers.entity.Section;
import com.example.HackatonByGreatDevelopers.entity.SectionBody;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.HackatonByGreatDevelopers.services.TestService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;



    @PostMapping
    @Operation(summary = "Получение текста с фронта и парсинг на фразы. Фразы которые сохранены в БД вернутся " +
            "с соответсвующим флагом, к фразам, соответствия которым не найдены в БД будут предложены " +
            "варианты.")
    public List<Section> test(@RequestBody List<SectionBody> sectionBodyList) throws IOException {
        return testService.test(sectionBodyList);
    }
}