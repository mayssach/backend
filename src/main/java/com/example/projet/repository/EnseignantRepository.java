package com.example.projet.repository;

import com.example.projet.model.entity.Enseignant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant,Long> {
}
