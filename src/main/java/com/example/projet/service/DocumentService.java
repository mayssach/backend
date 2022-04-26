package com.example.projet.service;

import com.example.projet.model.entity.Document;
import com.example.projet.model.entity.Niveau;
import com.example.projet.model.entity.Section;
import com.example.projet.model.entity.TypeDoc;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

public interface DocumentService {

    Document storeNiv(MultipartFile file, Long niveau, Long typeDoc) throws IOException;
    Document storeSec(MultipartFile file,Long section,Long typeDoc) throws IOException;
    Document getDocument(String idDoc);
    Stream<Document> getAllDocuments();
    Stream<Document> getAllDocumentsBySectType(Long idSec,Long idType);
    Stream<Document> getAllDocumentsByNivType(Long idNiv,Long idType);
}
