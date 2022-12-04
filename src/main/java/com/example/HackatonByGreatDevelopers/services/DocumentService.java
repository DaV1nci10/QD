package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.Document;
import com.example.HackatonByGreatDevelopers.entity.DocumentDto;
import com.example.HackatonByGreatDevelopers.entity.Section;
import com.example.HackatonByGreatDevelopers.entity.SectionBody;
import com.example.HackatonByGreatDevelopers.model.Anamnez;
import com.example.HackatonByGreatDevelopers.repositories.AnamnezRepository;
import com.example.HackatonByGreatDevelopers.repositories.DocumentRepository;
import com.example.HackatonByGreatDevelopers.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.common.text.Text;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Table(name = "documents")
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final PatientRepository patientRepository;
    private final AnamnezRepository anamnezRepository;
    public ResponseEntity<?> saveDoc(DocumentDto documentDto){
        String text = getTextFromDto(documentDto.getSections());
        Document document = new Document();
        document.setIin(documentDto.getIin());
        document.setFio(documentDto.getFio());
        document.setDob(documentDto.getDob());
        document.setDoctor(documentDto.getDoctor());
        document.setDateOfCreation(String.valueOf(LocalDateTime.now()));
        document.setText(text);


        for(int i = 0; i < documentDto.getSections().size(); i++){
            Anamnez anamnez = new Anamnez();
            anamnez.setAnamnezName(documentDto.getSections().get(i).getSectionCode());
            anamnez.setDoctor(document.getDoctor());
            anamnez.setEditable(true);
            anamnez.setContent(documentDto.getSections().get(i).getText());
            anamnez.setPatient_id(patientRepository.findPatientByIin(documentDto.getIin()));
            anamnezRepository.save(anamnez);
        }

        return ResponseEntity.ok(documentRepository.save(document));
    }

    String getTextFromDto(List<SectionBody> sections){
        String text = new String();
        for (int i = 0; i< sections.size(); i++) {
            text += sections.get(i).getSectionCode() + "\n";
            text += sections.get(i).getText() + "\n";
        }
        return text;
    }

    public List<Document> getDocumentsById(String iin){
        return documentRepository.getDocumentsByIin(iin);
    }


}
