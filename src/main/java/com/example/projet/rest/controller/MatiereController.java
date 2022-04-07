package com.example.projet.rest.controller;


import com.example.projet.model.entity.Matiere;
import com.example.projet.rest.dto.MatiereDto;
import com.example.projet.service.MatiereService;
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
public class MatiereController {
    @Autowired
    private MatiereService matiereService ;
    @Autowired
    private ModelMapper modelMapper ;


    @GetMapping("/Matieres")
    public Object Matierelist() {
        List<Matiere> mat= matiereService.getMatiereList();
        Type listType = new TypeToken<List<MatiereDto>>() {}.getType() ;
        List <MatiereDto> matdto= modelMapper.map(mat,listType);
        return ResponseEntity.status(HttpStatus.OK).body(matdto);
    }
    @GetMapping("/Matieres/{idmatiere}")
    public Object Matiere(@PathVariable Long idmatiere ) {
        Matiere e = matiereService.getMatiere(idmatiere) ;
        MatiereDto matdto= modelMapper.map(e, MatiereDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(matdto);
    }

    @PostMapping("/Matieres")
    public Object AddMatiere(@Validated @RequestBody MatiereDto matdto)
    {
        Matiere mat = modelMapper.map(matdto, Matiere.class);
        mat = matiereService.AddMatiere(mat);
        matdto = modelMapper.map(mat, MatiereDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(matdto);
    }

    @PutMapping("/Matieres/{idmatiere}")
    public Object UpdateMatiere (@Validated @RequestBody MatiereDto matdto , @PathVariable Long idmatiere) {
        Matiere mat = modelMapper.map(matdto,Matiere.class);
        mat= matiereService.UpdateMatiere(idmatiere, mat);
        matdto = modelMapper.map(mat,MatiereDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(matdto);

    }

    @DeleteMapping("/Matieres/{idmatiere}")
    public Object DeleteMatiere(@PathVariable Long idmatiere) {
        matiereService.DeleteMatiere(idmatiere);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
