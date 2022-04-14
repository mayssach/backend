package com.example.projet.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
