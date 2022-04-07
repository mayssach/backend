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
@Table(name = "SECTIONMATIERE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SectionMatiere implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Niveau id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ens_generator")
    @SequenceGenerator(name = "ens_generator", sequenceName = "ens_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idSectionMatiere", updatable = false, nullable = false)
    private Long idSectionMatiere ;

    @Column(name="libelle")
    private String libelle ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION", nullable = false)
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATIERE", nullable = false)
    private Matiere matiere;


}
