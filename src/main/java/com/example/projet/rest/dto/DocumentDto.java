package com.example.projet.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.Lob;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentDto {
    private Long idDocument ;
    private String nom ;
    private String description ;
    private String type ;
    private Date dateCreation ;
    private Date dateModif ;
    private MultipartFile fichier;

}
