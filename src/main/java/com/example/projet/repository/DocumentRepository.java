package com.example.projet.repository;

import com.example.projet.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document,String>  {
    List<Document> findDocumentByNiveauIdNiveauAndTypeDocIdTypeDoc(long idViveau,Long idTypeDoc);
    List<Document> findDocumentBySectionIdSectionAndTypeDocIdTypeDoc(long idSection,Long idTypeDoc);
}