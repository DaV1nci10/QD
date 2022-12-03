package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Section;
import com.example.HackatonByGreatDevelopers.entity.SectionBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.HackatonByGreatDevelopers.services.TestService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping
    public List<Section> test(@RequestBody List<SectionBody> sectionBodyList) throws IOException {
        return testService.test(sectionBodyList);
    }
}