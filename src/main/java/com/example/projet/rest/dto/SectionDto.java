package com.example.projet.rest.dto;

import com.example.projet.model.entity.Niveau;
import com.example.projet.model.entity.SectionMatiere;
import com.example.projet.model.entity.Specialite;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionDto {
    private Long idSection ;
    private String libelle ;
    private String libelleNiv ;
    private String libelleSpec ;
 //   private SpecialiteDto specialite;
   // private List<SectionMatiere> sectionMatieres;
}
