package com.example.projet.service.Imp;

import com.example.projet.model.entity.Document;
import com.example.projet.model.entity.Niveau;
import com.example.projet.model.entity.Section;
import com.example.projet.model.entity.TypeDoc;
import com.example.projet.repository.DocumentRepository;
import com.example.projet.service.DocumentService;
import com.example.projet.service.NiveauService;
import com.example.projet.service.SectionService;
import com.example.projet.service.TypeDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class DocumentImpService implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository ;
    @Autowired
    private TypeDocService typeDocService;
    @Autowired
    private NiveauService niveauService;
    @Autowired
    private SectionService sectionService;
    @Override
    public Document storeSec(MultipartFile file, Long idsection , Long idtypeDoc) throws IOException {
        Section section = sectionService.getSection(idsection);
        TypeDoc typeDoc = typeDocService.getTypeDoc(idtypeDoc);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(fileName, file.getContentType(), file.getBytes(), new Date(),(file.getSize()*0.00000095367432));
        document.setTypeDoc(typeDoc);
        document.setSection(section);
        return documentRepository.save(document);
    }

    @Override
    public Document storeNiv(MultipartFile file, Long idniveau,Long idtypeDoc) throws IOException {
        Niveau niveau = niveauService.getNiveau(idniveau);
        TypeDoc typeDoc=typeDocService.getTypeDoc(idtypeDoc);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(fileName, file.getContentType(), file.getBytes(), new Date(),(file.getSize()*0.00000095367432));
        document.setNiveau(niveau);
        document.setTypeDoc(typeDoc);
        documentRepository.save(document);
        return documentRepository.save(document);
    }
    public Document store(MultipartFile file,Long idTYpeDoc) throws IOException {
        TypeDoc typeDoc= typeDocService.getTypeDoc(idTYpeDoc);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(fileName, file.getContentType(), file.getBytes(), new Date(),(file.getSize()*0.00000095367432));
        document.setTypeDoc(typeDoc);
        return documentRepository.save(document);
    }
    @Override
    public Document getDocument(String idDoc) {
        return documentRepository.findById(idDoc).get();
    }
    @Override
    public Stream<Document> getAllDocuments() {
        return documentRepository.findAll().stream();
    }
    @Override
    public Stream<Document> getAllDocumentsBySectType(Long idSec,Long idType) {
        return documentRepository.findDocumentBySectionIdSectionAndTypeDocIdTypeDoc(idSec,idType).stream();
    }
    @Override
    public Stream<Document> getAllDocumentsByNivType(Long idNiv,Long idType) {
        return documentRepository.findDocumentByNiveauIdNiveauAndTypeDocIdTypeDoc(idNiv,idType).stream();
    }
    @Override
    public void DeleteDocument(String id) {
        documentRepository.deleteById(id);
    }
}