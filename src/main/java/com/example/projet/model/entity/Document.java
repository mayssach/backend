package com.example.projet.model.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "DOCUMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Document implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Document id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_generator")
    @SequenceGenerator(name = "doc_generator", sequenceName = "doc_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idDocument", updatable = false, nullable = false)
    private Long idDocument ;

    @Column(name="nom")
    private String nom ;

    @Column(name="description")
    private String description ;

    @Column(name="type")
    private String type ;

    @Column(name="dateCreation")
    private Date dateCreation ;

    @Column(name="dateModif")
    private Date dateModif ;

    private byte[]  fichier;

    public Document(String nom, String type, byte[] fichier) {
        this.nom = nom;
        this.type = type;
        this.fichier = fichier;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPEDOC", nullable = false)
    private TypeDoc typeDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION", nullable = false)
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIVEAU", nullable = false)
    private Niveau niveau;

}
