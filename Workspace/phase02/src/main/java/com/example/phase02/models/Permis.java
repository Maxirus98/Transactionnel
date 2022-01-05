package com.example.phase02.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Permis {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idPermis;

    @NotNull
    private String typePermis;

//    @Temporal(TemporalType.DATE)
//    private Date datePermis;
//   ou
    private LocalDate datePermis;
    private LocalDate dateExpiration;

    public Permis () {
        setDatePermis(LocalDate.now());
        setDateExpiration(datePermis.plusDays(15));
    }

}
