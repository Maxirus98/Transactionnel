package com.admin.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Citoyen {
    @Id
    private int id;
    private String prenom;
    private String nom;
    private int age;
    private char sexe;
    private String courriel;
    private String telephone;
    private String password;
    private String nassm;
}
