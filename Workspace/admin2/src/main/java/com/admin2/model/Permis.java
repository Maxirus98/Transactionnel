package com.admin2.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Permis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPermis;
    private String typePermis;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String nassm;
    private boolean expired;
    private String region;


    // Générer le code qr en byte
    @Lob
    @Column(name ="qrcode", columnDefinition = "BLOB")
    private byte[] qrCode;

    //cascade pour faire passer les usecases SEULEMENT --> CA FAIT BUG L'APPLICATION
    @OneToOne(targetEntity = Citizen.class/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "ID_CITOYEN")
    private Citizen citizen;

    public Permis() {
        dateDebut = LocalDate.now();
        setExpired(false);
    }
}
