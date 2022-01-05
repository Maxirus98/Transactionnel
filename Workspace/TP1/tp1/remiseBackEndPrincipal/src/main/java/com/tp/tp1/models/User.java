package com.tp.tp1.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@MappedSuperclass
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String courriel;
    private String password;
    private String nom;
    private String prenom;
}
