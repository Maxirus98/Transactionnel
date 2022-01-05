package com.example.mobile.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue
    private int id;
    private String country;
    private String city;
}
