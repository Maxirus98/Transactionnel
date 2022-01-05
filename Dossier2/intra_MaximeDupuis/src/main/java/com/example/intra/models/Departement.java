package com.example.intra.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Departement {
    @Id
    @GeneratedValue
    private int id;
    private String sigle;
    private String nom;

    @OneToOne
    private Enseignant responsable;
    @OneToMany
    private Set<Enseignant> enseignants;
}
