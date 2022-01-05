package com.mysql.rencontre07.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Permis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // créer une séquence de id PAR TABLE
    private int id;

    @NotNull
    private String typePermis;

}
