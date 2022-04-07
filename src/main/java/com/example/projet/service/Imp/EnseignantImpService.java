package com.example.projet.service.Imp;

import com.example.projet.model.entity.Enseignant;
import com.example.projet.repository.EnseignantRepository;
import com.example.projet.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantImpService implements EnseignantService {
    @Autowired
    private EnseignantRepository ensRepos ;
    @Override
    public Enseignant getEnseignant(Long id) {
        return ensRepos.findById(id).get();
    }

    @Override
    public List<Enseignant> getEnseignantList() {
        return (List<Enseignant>)ensRepos.findAll();
    }

    @Override
    public Enseignant AddEnseignant(Enseignant e) {
        return ensRepos.save(e);
    }

    @Override
    public Enseignant UpdateEnseignant(Long id, Enseignant e) {
        getEnseignant(id);
        e.setIdens(id);
        return ensRepos.save(e);
    }

    @Override
    public void DeleteEnseignant(Long id) {
    ensRepos.deleteById(id);
    }
}
