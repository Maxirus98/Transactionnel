package com.tp.tp1.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Citoyen extends User{
    private char sexe;
    private int age;
    private String telephone;
    private String nassm;
}
