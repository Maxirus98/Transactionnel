package com.tp.tp1.models;

import lombok.Builder;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Permis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPermis;
    private String typePermis;
    private LocalDate dateDebut;

    @Lob
    @Column(name ="qrcode", columnDefinition = "BLOB")

    private byte[] qrBitMap;

    @OneToOne(targetEntity=Citoyen.class)
    @JoinColumn(name = "ID_CITOYEN")
    private Citoyen citoyen;

    public Permis() {
        dateDebut = LocalDate.now();
    }
}
