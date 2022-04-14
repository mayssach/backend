package com.example.projet.repository;

import com.example.projet.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {
    List<Document> findDocumentByNiveauIdNiveau(long idViveau);
    List<Document> findDocumentBySectionIdSection(long idSection);

}