package com.example.projet.rest.controller;

import com.example.projet.model.entity.TypeDoc;
import com.example.projet.model.entity.Utilisateur;
import com.example.projet.rest.dto.TypeDocDto;
import com.example.projet.rest.dto.UtilisateurDto;
import com.example.projet.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin
public class UtilsateurController {
    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private ModelMapper modelMapper ;


    @GetMapping("/Utilisateurs")
    public Object Utilisateurlist() {
        List<Utilisateur> utilisateur= utilisateurService.getUtilisateurActiveList();
        Type listUser = new TypeToken<List<UtilisateurDto>>() {}.getType() ;
        List <UtilisateurDto> utilisateurDtos= modelMapper.map(utilisateur,listUser);
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurDtos);
    }
    @GetMapping("/Utilisateurs/request")
    public Object UtilisateurNotActivelist() {
        List<Utilisateur> utilisateur= utilisateurService.getUtilisateurNotActiveList();
        Type listUser = new TypeToken<List<UtilisateurDto>>() {}.getType() ;
        List <UtilisateurDto> utilisateurDtos= modelMapper.map(utilisateur,listUser);
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurDtos);
    }
    @PutMapping ("/Utilisateurs/{id}")
    public Object ActiverUtilisateur(@Validated @RequestBody UtilisateurDto dto,@PathVariable Long id) {
        Utilisateur utilisateur = modelMapper.map(dto,Utilisateur.class);
        utilisateur= utilisateurService.ActiverUtilisateur(id);
        dto = modelMapper.map(utilisateur,UtilisateurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/Utilisateurs/{id}")
    public Object GetUtilisateur(@PathVariable Long id ) {
        Utilisateur e = utilisateurService.getUtilisateur(id) ;
        UtilisateurDto dto= modelMapper.map(e, UtilisateurDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/Utilisateurs/{id}")
    public Object DeleteUtilisateur(@PathVariable Long id) {
        utilisateurService.DeleteUtilisateur(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
