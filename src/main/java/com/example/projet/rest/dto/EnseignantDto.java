package com.example.projet.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

    public class EnseignantDto {
    private Long idens ;
    private Long cin ;
    private String nom ;
    private String prenom ;
    private String dateNais ;
    private long numTel ;
    private String email ;
}
