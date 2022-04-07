package com.example.projet.service;

import com.example.projet.model.entity.SectionMatiere;

import java.util.List;

public interface SectionMatiereService {
    SectionMatiere getSectionMatiere(Long id);
    List<SectionMatiere> getSectionMatiereList(Long id);
    SectionMatiere AddSectionMatiere(SectionMatiere e);
    SectionMatiere UpdateSectionMatiere(Long id,SectionMatiere e);
    void DeleteSectionMatiere(Long id);
}
