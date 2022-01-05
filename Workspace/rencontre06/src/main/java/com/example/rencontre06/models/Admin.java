package com.example.rencontre06.models;

import lombok.Data;

import javax.persistence.Entity;


@Entity
@Data
public class Admin extends User{
    private String role;
}
