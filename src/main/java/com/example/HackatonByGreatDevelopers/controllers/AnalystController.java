package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.DeepSearch;
import com.example.HackatonByGreatDevelopers.services.AnalystService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/analyst")
public class AnalystController {

    private final AnalystService analystService;

    @PostMapping("/deepSearch")
    public List<String> deepSearch(@RequestBody List<DeepSearch> deepSearches){
        return analystService.deepSearch(deepSearches);
    }
}
