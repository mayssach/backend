package com.example.projet.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "MATIERE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mat_generator")
    @SequenceGenerator(name = "mat_generator", sequenceName = "mat_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idmatiere", updatable = false, nullable = false)
    private Long idmatiere ;

    @Column(name="nomMatiere")
    private String nomMatiere ;

    @OneToMany(mappedBy="matiere")
    private List<SectionMatiere> sectionMatieres;


}
