package ca.qc.cal.rencontre01.ca.qc.cal.rencontre01.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//Javax persistence @Entity = Table
//SGBDR IL FAUT RESPECTER ACID
//Va créer la table dans la bd par lui-même grâce au fichier application.properties

@Entity
@Data
public class Employee implements Serializable{
    //Serializable, class va traverser un flux
    //SGBDR = Système de Gestion de base de données relationnel
    // Design Pattern de A.C.I.D

    //hashCode et equals --> servent à trier
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private int age;
    //Changer le nom de la colonne dans la table par IOC
    @Column(name="TOWN")
    private String ville;
    private String salaire;
    private String poste;


}
