package com.example.intra.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Etudiant extends PopulationCollege{
    private int matricule;
    private Date anneeEntreeCollege;

    @OneToMany
    private Set<Matiere> matieres;
}
