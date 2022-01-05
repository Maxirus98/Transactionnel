package com.example.rencontre06.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value = "U")
@DiscriminatorColumn(name="TOTO", discriminatorType = DiscriminatorType.STRING)
public class User {
    //Les attributs de tous les classes de User vont se trouver commes des champs dans BD
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;
}
