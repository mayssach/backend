package com.example.projet.service.Imp;


import com.example.projet.model.entity.Matiere;
import com.example.projet.repository.MatiereRepository;
import com.example.projet.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereImpService implements MatiereService {
    @Autowired
    private MatiereRepository matRepos ;
    @Override
    public Matiere getMatiere(Long id) {
        return matRepos.findById(id).get();
    }

    @Override
    public List<Matiere> getMatiereList() {
        return (List<Matiere>)matRepos.findAll();
    }

    @Override
    public Matiere AddMatiere(Matiere e) {
        return matRepos.save(e);
    }

    @Override
    public Matiere UpdateMatiere(Long id, Matiere e) {
        getMatiere(id);
        e.setIdmatiere(id);
        return matRepos.save(e);
    }


    @Override
    public void DeleteMatiere(Long id) {
        matRepos.deleteById(id);
    }
}
