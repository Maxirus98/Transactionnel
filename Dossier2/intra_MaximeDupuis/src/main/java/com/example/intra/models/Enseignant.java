package com.example.intra.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class Enseignant extends PopulationCollege{
    private Date priseEnFonction;
    private int indice;

    @OneToOne
    private Matiere matiere;
}
