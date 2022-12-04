package com.example.HackatonByGreatDevelopers.controllers;

import com.example.HackatonByGreatDevelopers.entity.Document;
import com.example.HackatonByGreatDevelopers.entity.DocumentDto;
import com.example.HackatonByGreatDevelopers.services.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/documents")
public class DocumentsController {

    private final DocumentService documentService;

    @PostMapping("/save")
    @Operation(summary = "Добавление документа в БД")
    ResponseEntity<?> saveDocument(@RequestBody DocumentDto documentDto){
        return documentService.saveDoc(documentDto);
    }

    @GetMapping("{iin}")
    @Operation(summary = "Получение всех документов на основе ИИН пациента")
    List<Document> getDocumentsById(@PathVariable String iin){
        return documentService.getDocumentsById(iin);
    }
}
