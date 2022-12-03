package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.Document;
import com.example.HackatonByGreatDevelopers.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequiredArgsConstructor
public class DocumentService {
    DocumentRepository documentRepository;

    public ResponseEntity<?> saveDoc(Document document){
        return ResponseEntity.ok(documentRepository.save(document));
    }
}
