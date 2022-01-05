package com.example.intra.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Matiere {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private String sigle;

    @OneToMany
    private Set<Enseignant> enseignants;
}
