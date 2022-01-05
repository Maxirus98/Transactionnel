package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Aeroport {
    @Id
    private int id;
    @OneToMany
    private Set<Ville> villes;
}
