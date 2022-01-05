package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
public class Compagnie {
    @Id
    private int id;

    @ManyToMany(targetEntity=Vol.class)
    private Set<Vol> vol;
}
