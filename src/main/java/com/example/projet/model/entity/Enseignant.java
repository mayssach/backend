package com.example.projet.model.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "ENSEIGNANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enseignant implements Serializable {

        /**
         * generated serial ID
         */
        private static final long serialVersionUID = 1L;

        /**
         * Enseignant id
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ens_generator")
        @SequenceGenerator(name = "ens_generator", sequenceName = "ens_SEQ", initialValue = 1, allocationSize = 1)
        @Column(name = "idens", updatable = false, nullable = false)
        private Long idens ;

        @Column(name="cin")
        private Long cin ;

        @Column(name="nom")
        private String nom ;

        @Column(name="prenom")
        private String prenom ;

        @Column(name="dateNais")
        private String dateNais ;

        @Column(name="numTel")
        private long numTel ;

        @Column(name="email")
        private String email ;

}
