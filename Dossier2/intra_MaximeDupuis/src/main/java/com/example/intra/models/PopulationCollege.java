package com.example.intra.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class PopulationCollege {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String mail;
}
