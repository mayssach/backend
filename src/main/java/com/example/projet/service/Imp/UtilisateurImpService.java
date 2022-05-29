package com.example.projet.service.Imp;

import com.example.projet.model.entity.Utilisateur;
import com.example.projet.repository.UserRepository;
import com.example.projet.repository.UtilisateurRepository;
import com.example.projet.rest.dto.UtilisateurDto;
import com.example.projet.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilisateurImpService implements UtilisateurService {
    @Autowired
    private UserRepository utilisateurRepository ;

    @Override
    public Utilisateur getUtilisateur(Long id) { return utilisateurRepository.findById(id).get(); }

    @Override
    public List<Utilisateur> getUtilisateurActiveList() {
        return (List<Utilisateur>)utilisateurRepository.findUtilisateurByActive(1); }
    @Override
    public List<Utilisateur> getUtilisateurNotActiveList() {
        return (List<Utilisateur>)utilisateurRepository.findUtilisateurByActive(0); }
    @Override
    public Utilisateur AddUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur UpdateUtilisateur(Long id, Utilisateur utilisateur) {
        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void DeleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public Utilisateur ActiverUtilisateur(Long id) {
        Utilisateur u=utilisateurRepository.findById(id).get();
        u.setActive(1);
        return utilisateurRepository.save(u);
    }
}
