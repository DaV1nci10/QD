package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Section;
import com.example.HackatonByGreatDevelopers.entity.SectionBody;
import com.example.HackatonByGreatDevelopers.services.TestService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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