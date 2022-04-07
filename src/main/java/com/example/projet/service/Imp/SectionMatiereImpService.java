package com.example.projet.service.Imp;

import com.example.projet.model.entity.Section;
import com.example.projet.model.entity.SectionMatiere;
import com.example.projet.repository.SectionMatiereRepository;
import com.example.projet.repository.SectionRepository;
import com.example.projet.service.SectionMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionMatiereImpService implements SectionMatiereService {
    @Autowired
    private SectionMatiereRepository sectionMatiereRepository ;

    @Override
    public SectionMatiere getSectionMatiere(Long id) {
        return sectionMatiereRepository.findById(id).get();
    }

    @Override
    public List<SectionMatiere> getSectionMatiereList(Long id) {
        return (List<SectionMatiere>)sectionMatiereRepository.findByMatiereIdmatiere(id);
    }

    @Override
    public SectionMatiere AddSectionMatiere(SectionMatiere e) {
        return sectionMatiereRepository.save(e);
    }

    @Override
    public SectionMatiere UpdateSectionMatiere(Long id, SectionMatiere e) {
        getSectionMatiere(id);
        e.setIdSectionMatiere(id);
        return sectionMatiereRepository.save(e);
    }


    @Override
    public void DeleteSectionMatiere(Long id) {
        sectionMatiereRepository.deleteById(id);
    }
}
