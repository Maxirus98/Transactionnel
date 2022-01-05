package com.tp.tp1.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class PermisTest extends Permis{
    public final static int PLUS_DAYS = 15;
    @NotNull
    private LocalDate dateFin;
    @NotNull
    private boolean expired;

    public PermisTest(){
        dateFin = this.getDateDebut().plusDays(PermisTest.PLUS_DAYS);
        setExpired(false);
    }
}
