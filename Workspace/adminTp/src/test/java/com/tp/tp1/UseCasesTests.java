package com.tp.tp1;

import com.tp.tp1.models.Citoyen;
import com.tp.tp1.models.Permis;
import com.tp.tp1.repository.PermisRepository;
import com.tp.tp1.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//POUR BYPASS LE STATIC
@ComponentScan(basePackages = {"com.tp.tp1.services"})
public class UseCasesTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermisRepository permisRepository;

    @BeforeAll
    public void insererDonnees(){
        Citoyen citoyen1 = new Citoyen();
        //Permis Vaccin
        Permis permis1 = new Permis();

        citoyen1.setCourriel("dupuismaxime@hotmail.com");citoyen1.setNom("Dupuis");
        citoyen1.setNassm("123456890");
        citoyen1.setPrenom("Maxime");citoyen1.setAge(12);citoyen1.setTelephone("514-111-2222");citoyen1.setSexe('M');
        citoyen1.setPassword("mdp");
        //Choisi le typePermis automatiquement en fonction de l'âge.
        permis1.setTypePermis("vaccin");
        permis1.setCitoyen(citoyen1);


        Citoyen citoyen2 = new Citoyen();
        Permis permis2 = new Permis();


        citoyen2.setCourriel("dm@hotmail.com");citoyen2.setNom("Doré");
        citoyen2.setNassm("123456890");
        citoyen2.setPrenom("Mathieu");citoyen2.setAge(22);citoyen2.setTelephone("514-222-1111");citoyen2.setSexe('F');
        citoyen2.setPassword("motdepasse");
        permis2.setTypePermis("test");
        permis2.setCitoyen(citoyen2);


        permisRepository.saveAll(Arrays.asList(permis1, permis2));
        userRepository.saveAll(Arrays.asList(citoyen1, citoyen2));
    }

    @Test
    @Disabled
    public void trouverTousUtilisateurs(){
        assertEquals(2, userRepository.findAll().size());
    }
    @Test
    @Disabled
    public void trouverUtilisateurParCourrielEtMdp(){
        assertEquals("Dupuis", userRepository.findCitoyenByCourrielAndPassword("dupuismaxime@hotmail.com", "mdp").getNom());
    }
    @Test
    @Disabled
    public void trouverTousPermis(){
        assertEquals(2, permisRepository.findAll().size());
    }

    @Test
    @Disabled
    public void supprimerCitoyenParCourrielEtMdp(){
        assertEquals(1, userRepository.deleteCitoyenByCourrielAndPassword("dm@hotmail.com", "motdepasse"));
    }

    @Test
    @Disabled
    public void supprimerPermisParCourrielEtMdpDeCitoyen(){
        assertEquals(1, permisRepository.deletePermisByCitoyen_CourrielAndCitoyen_Password("dm@hotmail.com", "motdepasse"));
    }

    @Test
    @Disabled
    public void verifierSiPermisActif(){
        assertTrue(permisRepository.findPermisTestByCitoyen_CourrielAndCitoyen_Password("dm@hotmail.com", "motdepasse").getDateFin().isAfter(LocalDate.now()));
    }
    @Test
    @Disabled
    public void connecter(){
        assertEquals("dm@hotmail.com", userRepository.findCitoyenByCourrielAndPassword("dm@hotmail.com", "motdepasse").getCourriel());
    }
    @Test
    @Disabled
    public void inscrire(){
        assertNotNull(userRepository.findCitoyenByCourrielOrPassword("dm@hotmail.com", "motdepasse"));
        assertNotNull(userRepository.save(userRepository.findCitoyenByCourrielOrPassword("dm@hotmail.com", "motdepasse")));
    }
}

