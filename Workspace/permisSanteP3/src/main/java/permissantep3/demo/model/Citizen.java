package permissantep3.demo.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Citizen implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String prenom;
    private String nom;
    private String courriel;
    private String password;



}
