package com.example.projet.repository;

import com.example.projet.model.entity.TypeDoc;
import com.example.projet.model.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {
    Utilisateur findByUsernameAndPassword(String username,String password);
}
