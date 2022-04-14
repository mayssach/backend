package com.example.projet.service;

import com.example.projet.model.entity.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface DocumentService {

    Document getDocument(Long id);
    Stream<Document> getDocumentList();
    Stream<Document> getDocumentListSec(Long idSection);
    Stream<Document> getDocumentListColg(Long idNiveau);
    Document AddDocument(MultipartFile document) throws IOException;
    Document UpdateDocument(Long id,Document document);
    void DeleteDocument(Long id);
}
