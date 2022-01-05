package com.example.intra.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class College {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String siteInternet;

    @OneToMany
    private Set<Departement> departements;
}
