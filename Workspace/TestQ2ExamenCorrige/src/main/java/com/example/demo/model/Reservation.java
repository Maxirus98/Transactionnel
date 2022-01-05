package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Reservation {
    @Id
    private int id;
    @OneToOne
    private Vol vol;
    @OneToOne
    private Passager passager;
    private String etat;
}
