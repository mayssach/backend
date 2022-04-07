package com.example.projet.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionMatiereDto {
    private Long idSectionMatiere ;
    private String libelle ;
    private Date dateCrea ;
    private Date dateModif ;
    private SectionDto section;
    private MatiereDto matiere;
}
