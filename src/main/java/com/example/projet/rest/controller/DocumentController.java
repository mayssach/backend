package com.example.projet.rest.controller;

import com.example.projet.message.ResponseFile;
import com.example.projet.message.ResponseMessage;
import com.example.projet.model.entity.Document;
import com.example.projet.model.entity.Niveau;
import com.example.projet.model.entity.Section;
import com.example.projet.model.entity.TypeDoc;
import com.example.projet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private TypeDocService typeDocService;
    @Autowired
    private NiveauService niveauService;
   @PostMapping("Sections/{idSec}/TypeDocs/{idType}/document")
    public ResponseEntity<ResponseMessage> uploadFileSection(@PathVariable Long idSec,@PathVariable Long idType,@RequestParam("document") MultipartFile file) {
        String message = "";
        try {
            documentService.storeSec(file,idSec,idType);
            message = "Le fichier a été téléchargé avec succès:" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible de télécharger le fichier: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @PostMapping("Niveaux/{idNiv}/TypeDocs/{idType}/document")
    public ResponseEntity<ResponseMessage> uploadFileNiveau(@PathVariable Long idNiv,@PathVariable Long idType,@RequestParam("document") MultipartFile file) {
        String message = "";
        try {
            documentService.storeNiv(file,idNiv,idType);

            message = "Le fichier a été téléchargé avec succès:" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible de télécharger le fichier: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping("Niveaux/{idNiv}/TypeDocs/{idType}/documents")
    public ResponseEntity<List<ResponseFile>> getListFilesNiv(@PathVariable Long idNiv,@PathVariable Long idType) {
        List<ResponseFile> documents = documentService.getAllDocumentsByNivType(idNiv,idType).map(document -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documents/")
                    .path(document.getId())
                    .toUriString();
            return new ResponseFile(
                    document.getNom(),
                    fileDownloadUri,
                    document.getType(),
                    document.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(documents);
    }
    @GetMapping("Sections/{idSec}/TypeDocs/{idType}/documents")
    public ResponseEntity<List<ResponseFile>> getListFilesSec(@PathVariable Long idSec,@PathVariable Long idType) {
        List<ResponseFile> documents = documentService.getAllDocumentsBySectType(idSec,idType).map(document -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documents/")
                    .path(document.getId())
                    .toUriString();
            return new ResponseFile(
                    document.getNom(),
                    fileDownloadUri,
                    document.getType(),
                    document.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(documents);
    }


    @GetMapping("/documents/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Document document = documentService.getDocument(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getNom() + "\"")
                .body(document.getData());
    }
}
