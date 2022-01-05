package com.example.rencontre02.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    @Id
    private int id;
    private String nom;
    private String salaire;
    private int age;
    private String email;
    private String poste;
}
