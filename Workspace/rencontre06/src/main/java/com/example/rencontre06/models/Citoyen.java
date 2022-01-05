package com.example.rencontre06.models;

import lombok.Data;

import javax.persistence.Entity;

//JPA + Hibernate (Orange)
@Data
@Entity
public class Citoyen extends User{
    //Fait vaccin ou non?
    private boolean vaccin;
    private int age;
}
