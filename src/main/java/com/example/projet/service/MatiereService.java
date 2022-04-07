package com.example.projet.service;

import com.example.projet.model.entity.Matiere;

import java.util.List;

public interface MatiereService {

    Matiere getMatiere(Long id);
    List<Matiere> getMatiereList();
    Matiere AddMatiere(Matiere e);
    Matiere UpdateMatiere(Long id,Matiere e);
    void DeleteMatiere(Long id);
}
