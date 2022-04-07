package com.example.projet.repository;
import com.example.projet.model.entity.Niveau;
import com.example.projet.model.entity.SectionMatiere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionMatiereRepository extends CrudRepository<SectionMatiere,Long> {
    List<SectionMatiere> findByMatiereIdmatiere(Long id);
    List<SectionMatiere> findBySectionIdSection(Long id);
}
