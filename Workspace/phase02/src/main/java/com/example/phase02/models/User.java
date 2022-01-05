package com.example.phase02.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import com.example.phase02.models.Permis;

@Entity
@Data
public class User implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;

   @NotNull(message = "Login est obligatoire") //Gestion du message
   private String login;
   @NotNull(message = "Le Mot de passe est obligatoire")
   private String password;
   @OneToOne(targetEntity = Permis.class)
   @JoinColumn(name = "ID_PERMIS")
   private Permis permis;
}
