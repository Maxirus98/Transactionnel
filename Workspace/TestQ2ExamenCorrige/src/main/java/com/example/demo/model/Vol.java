package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Vol {

    @Id
    private int id;
    private String noVol;
    private Date jourDepart;
    private Date jourArrive;

    @OneToOne
    private Aeroport depart;
    @OneToOne
    private Aeroport arrive;
    @OneToMany
    private Set<Aeroport> escales;



}
