package com.example.projet.service.Imp;

import com.example.projet.model.entity.Document;
import com.example.projet.repository.DocumentRepository;
import com.example.projet.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class DocumentImpService implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository ;

    @Override
    public Document getDocument(Long id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public Stream<Document> getDocumentList() {
        return documentRepository.findAll().stream();
    }

    @Override
    public Stream<Document> getDocumentListSec(Long idSection) {
        return documentRepository.findDocumentBySectionIdSection(idSection).stream();    }

    @Override
    public Stream<Document> getDocumentListColg(Long idNiveau) {
        return documentRepository.findDocumentByNiveauIdNiveau(idNiveau).stream();    }

    @Override
    public Document AddDocument(MultipartFile file) throws IOException {
        String nom = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(nom, file.getContentType(),file.getBytes());
        return documentRepository.save(document);
    }

    @Override
    public Document UpdateDocument(Long id, Document document) {
        getDocument(id);
        document.setIdDocument(id);
        return documentRepository.save(document);
    }

    @Override
    public void DeleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
