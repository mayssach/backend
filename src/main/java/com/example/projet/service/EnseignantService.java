package com.example.projet.service;

import com.example.projet.model.entity.Enseignant;

import java.util.List;

public interface EnseignantService {
    Enseignant getEnseignant(Long id);
    List<Enseignant> getEnseignantList();
    Enseignant AddEnseignant(Enseignant e);
    Enseignant UpdateEnseignant(Long id,Enseignant e);
    void DeleteEnseignant(Long id);
}