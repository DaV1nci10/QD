package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.MyString;
import com.example.HackatonByGreatDevelopers.entity.SearchPatient;
import com.example.HackatonByGreatDevelopers.entity.User;
import com.example.HackatonByGreatDevelopers.services.SearchPatientService;
import com.example.HackatonByGreatDevelopers.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/firstTest")
@RequiredArgsConstructor
public class SearchPatientController {

    @Autowired
    private UserService userService;
    private final SearchPatientService searchPatientService;

    @GetMapping("getAllByUserId/{id}")
    public User getAllById(@PathVariable Long id){
        return userService.getAllByUserId(id);
    }

    @Operation(summary = "Умный поиск всех пациентов по ИИН. В поисковом поле отображение автозаполнения")
    @PostMapping("/search")
    List<SearchPatient> getPatientsSearch(@RequestBody MyString str) throws IOException {
        return searchPatientService.getSearchPatients(str.getSearchName(), "search");
    }


}
