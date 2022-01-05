package ministere.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Citoyen {
    @Id
    private int id;
    private String nom;
    private String prenom;
    private String nassm;
}
