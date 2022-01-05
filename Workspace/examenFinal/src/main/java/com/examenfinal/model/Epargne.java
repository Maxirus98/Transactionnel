package com.examenfinal.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Epargne extends Compte{
    private float sommeVisee;
    private float taux;
}
