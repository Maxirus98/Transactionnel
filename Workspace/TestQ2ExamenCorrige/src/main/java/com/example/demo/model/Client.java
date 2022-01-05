package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Client {
    @Id
    private int id;
    private String nom;
    private String prenom;
    @OneToMany
    private Set<Reservation> reservations;
}
