package com.p4.permissante.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Citizen implements Serializable {
    //Pas besoin du Generated Value puisque l'info est deja dans le ministere
    @Id
    private int id;
    private String courriel;
    private String password;
    private String nom;
    private String prenom;
    private char sexe;
    private int age;
    private String telephone;
    private String nassm;
}
