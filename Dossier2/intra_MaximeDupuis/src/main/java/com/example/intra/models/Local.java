package com.example.intra.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Local {
    @Id
    @GeneratedValue
    private int id;
    private String sigle;
    private int nombrePlaces;

    @OneToMany
    private Set<Matiere> matieresEnseignees;

}
