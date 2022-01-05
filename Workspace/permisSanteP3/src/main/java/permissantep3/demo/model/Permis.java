package permissantep3.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Permis implements Serializable {
    @Id
    @GeneratedValue
    private Integer idPermis;

    private String typePermis;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private boolean expired;

    public Permis(){
        setDateDebut(LocalDate.now());
        setDateFin(LocalDate.now().plusDays(15));
        setExpired(false);
    }

    @OneToOne(targetEntity = Citizen.class)
    @JoinColumn(name = "ID_CITIZEN")
    Citizen citizen;
}
