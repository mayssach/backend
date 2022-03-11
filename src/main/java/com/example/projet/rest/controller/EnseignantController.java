package com.example.projet.rest.controller;

import com.example.projet.model.entity.Enseignant;
import com.example.projet.rest.dto.EnseignantDto;
import com.example.projet.service.EnseignantService;
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
public class EnseignantController {
    @Autowired
    private EnseignantService enseignantService ;
    @Autowired
    private ModelMapper modelMapper ;


    @GetMapping("/Enseignants")
    public Object Enseignantlist() {
        List<Enseignant> ens= enseignantService.getEnseignantList();
        Type listType = new TypeToken <List<EnseignantDto>>() {}.getType() ;
        List <EnseignantDto> ensdto= modelMapper.map(ens,listType);
        return ResponseEntity.status(HttpStatus.OK).body(ensdto);
    }
    @GetMapping("/Enseignant")
    public Object Enseignant(@PathVariable Long id ) {
        Enseignant e = enseignantService.getEnseignant(id) ;
        EnseignantDto ensdto= modelMapper.map(e, EnseignantDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(ensdto);
    }

    @PostMapping("/Enseignant")
    public Object AddEnseignant(@PathVariable Long idens,@Validated @RequestBody EnseignantDto ensDto)
    {
        Enseignant ens = modelMapper.map(ensDto, Enseignant.class);
        ens = enseignantService.AddEnseignant(ens);
        ensDto = modelMapper.map(ens, EnseignantDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(ensDto);
    }

    @PutMapping("/Enseignant/{id}")
    public Object UpdateEnseignant (@Validated @RequestBody EnseignantDto ensDto , @PathVariable Long id) {
        Enseignant ens = modelMapper.map(ensDto,Enseignant.class);
        ens= enseignantService.UpdateEnseignant(id, ens);
        ensDto = modelMapper.map(ens,EnseignantDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(ensDto);

    }

    @DeleteMapping("/Enseignant/{id}")
    public Object DeleteEnseignant(@PathVariable Long id) {
        enseignantService.DeleteEnseignant(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
