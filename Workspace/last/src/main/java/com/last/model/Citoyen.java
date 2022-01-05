package com.last.model;

import com.last.myValidation.RHAnnotation;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.hibernate.annotations.NotFound;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
public class Citoyen implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @RHAnnotation
    private String prenom;
    private String nom;
    @RHAnnotation
    private String courriel;
    @NotBlank(message = "Password jamais vide")
    private String password;



}
