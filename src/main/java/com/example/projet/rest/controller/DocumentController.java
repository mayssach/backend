package com.example.projet.rest.controller;

import com.example.projet.model.entity.Document;
import com.example.projet.rest.dto.DocumentDto;
import com.example.projet.service.DocumentService;
import com.example.projet.service.NiveauService;
import com.example.projet.service.SectionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@RestController
@CrossOrigin
public class DocumentController {
    @Autowired
    private DocumentService documentService ;
    @Autowired
    private NiveauService niveauService ;
    @Autowired
    private SectionService sectionService ;
    @Autowired
    private ModelMapper modelMapper ;
    @GetMapping("/Documents")
    public Object Documentlist() {
        Stream<Document> mat= documentService.getDocumentList();
        Type listType = new TypeToken<List<DocumentDto>>() {}.getType() ;
        List <DocumentDto> documentDtos= modelMapper.map(mat,listType);
        return ResponseEntity.status(HttpStatus.OK).body(documentDtos);
    }
    @GetMapping("/Niveaux/{idNiveau}/Documents")
    public Object DocumentlistColg(@PathVariable Long idNiveau) {
        Stream<Document> mat= documentService.getDocumentListColg(idNiveau);
        Type listType = new TypeToken<List<DocumentDto>>() {}.getType() ;
        List <DocumentDto> documentDtos= modelMapper.map(mat,listType);
        return ResponseEntity.status(HttpStatus.OK).body(documentDtos);
    }
    @GetMapping("/Sections/{idsec}/Documents")
    public Object DocumentlistSec(@PathVariable Long idsec) {
        Stream<Document> mat= documentService.getDocumentListSec(idsec);
        Type listType = new TypeToken<List<DocumentDto>>() {}.getType() ;
        List <DocumentDto> documentDtos= modelMapper.map(mat,listType);
        return ResponseEntity.status(HttpStatus.OK).body(documentDtos);
    }

    @GetMapping("/Documents/{iddocument}")
    public Object Document(@PathVariable Long iddocument ) {
        Document e = documentService.getDocument(iddocument) ;
        DocumentDto dto= modelMapper.map(e, DocumentDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/Niveaux/{idNiveau}/Documents")
    public Object AddDocument(@PathVariable Long idNiveau,@Validated @RequestBody DocumentDto dto,@RequestParam("fichier") MultipartFile file) throws IOException {
        Document doc = modelMapper.map(dto, Document.class);
        Date dateCreation = new Date();
        doc.setDateCreation(dateCreation);
        doc.setNiveau(niveauService.getNiveau(idNiveau));
        doc = documentService.AddDocument(file);
        dto = modelMapper.map(doc, DocumentDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/Sections/{idSec}/Documents")
    public Object AddDocumentSec(@PathVariable Long idSec,@Validated @RequestBody DocumentDto dto,@RequestParam("file") MultipartFile file) throws IOException {
        Document doc = modelMapper.map(dto, Document.class);
        Date dateCreation = new Date();
        doc.setDateCreation(dateCreation);
        doc.setSection(sectionService.getSection(idSec));
        doc = documentService.AddDocument(file);
        dto = modelMapper.map(doc, DocumentDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/Documents/{iddocument}")
    public Object UpdateDocument (@Validated @RequestBody DocumentDto dto , @PathVariable Long iddocument) {
        Document document = modelMapper.map(dto,Document.class);
        document= documentService.UpdateDocument(iddocument, document);
        dto = modelMapper.map(document,DocumentDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @DeleteMapping("/Documents/{iddocument}")
    public Object DeleteDocument(@PathVariable Long iddocument) {
        documentService.DeleteDocument(iddocument);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
