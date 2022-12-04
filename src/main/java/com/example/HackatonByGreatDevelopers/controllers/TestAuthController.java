package com.example.HackatonByGreatDevelopers.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestAuthController {

    @GetMapping("/all")
    @Operation(summary = "проверка доступности, должен быть доступен без авторизации")
    public String allAccess() {
        return "public API";
    }

    @GetMapping("/user")
    @Operation(summary = "проверка доступности, должен быть доступен для user, admin, superAdmin")
    public String serAccess() {

        return "Test";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "проверка доступности, должен быть доступен для moderator, admin")
    public String moderatorAccess() {
        return "moderator API";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "проверка доступности, должен быть доступен для admin")
    public String adminAccess() {
        return "admin API";
    }

}
