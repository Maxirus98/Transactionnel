package com.mysql.rencontre07.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // créer une séquence de id PAR TABLE
    private int id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @OneToOne(targetEntity = Permis.class)
    @JoinColumn(name = "ID_PERMIS")
    private Permis permis;

}
