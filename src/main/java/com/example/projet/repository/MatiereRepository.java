package com.example.projet.repository;

import com.example.projet.model.entity.Matiere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends CrudRepository<Matiere,Long> {
}
