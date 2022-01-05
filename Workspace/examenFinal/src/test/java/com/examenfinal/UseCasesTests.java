package com.examenfinal;

import com.examenfinal.model.Compte;
import com.examenfinal.model.Epargne;
import com.examenfinal.repositories.CompteRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//POUR BYPASS LE STATIC
public class UseCasesTests {
    @Autowired
    private CompteRepository repository;

    @BeforeAll
    public void insererDonnees(){
        Compte compte = new Compte();
        compte.setNom("Max");
        compte.setPrenom("Dup");
        compte.setOuverture(20f);

        Epargne compte2 = new Epargne();
        compte2.setNom("Max2");
        compte2.setPrenom("Dup2");
        compte2.setOuverture(20f);
        compte2.setTaux(0.5f);
        compte2.setSommeVisee(2000f);

       repository.saveAll(Arrays.asList(compte, compte2));
    }

    @Test
    public void supprimerCompteEpargne(){
        repository.delete(repository.findCompteById(1));
        assertNull(repository.findCompteById(1));
    }

    @Test
    public void modiferCompteCheque(){
        repository.findCompteById(1).setOuverture(100);
        assertEquals(100, repository.findCompteById(1).getOuverture());
    }

    @Test
    public void modiferCompteEpargne(){
        repository.findEpargneById(2).setSommeVisee(5000);
        assertEquals(5000, repository.findEpargneById(2).getSommeVisee());
    }


}
