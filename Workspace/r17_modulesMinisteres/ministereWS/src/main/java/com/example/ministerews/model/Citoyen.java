package com.example.ministerews.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Citoyen implements Serializable {
    @Id
    private int id;
    private String name;
    private String numero;
    private boolean valid;
}
