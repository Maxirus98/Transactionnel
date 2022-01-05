package com.example.intra.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue
    private int id;
    private double nombre;

    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Matiere matiere;
}
