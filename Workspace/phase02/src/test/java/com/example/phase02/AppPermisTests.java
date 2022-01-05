package com.example.phase02;

import com.example.phase02.models.Permis;
import com.example.phase02.models.User;
import com.example.phase02.repositories.PermisRepository;
import com.example.phase02.repositories.UserRepository;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //POUR BYPASS LE STATIC
public class AppPermisTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermisRepository permisRepository;


    @BeforeAll //Code exécuté avant tout : en priorité
    public void insertData(){ //Arrange
        User u1 = new User();
        Permis p1 = new Permis(); // Les dates sont ajoutées dans le constructeur par défaut * Voir classe Permis

        p1.setTypePermis("VACCIN");
        u1.setLogin("Toto"); u1.setPassword("toto1234"); u1.setPermis(p1);


        User u2 = new User();
        Permis p2 = new Permis();

        p2.setTypePermis("TEST");
        u2.setLogin("Tata"); u2.setPassword("tata1234"); u2.setPermis(p2);

        Permis p3 = new Permis(); p3.setTypePermis("TEST");
        Permis p4 = new Permis(); p4.setTypePermis("TEST");
        Permis p5 = new Permis(); p5.setTypePermis("TEST");

        permisRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        userRepository.saveAll(Arrays.asList(u1, u2));
    }

    @Test
    @Disabled
    @DisplayName("Test select * from table User")
    public void findAllUsers(){
        assertEquals(2, userRepository.findAll().size());//Act
    }

    @Test
    @Disabled
    @DisplayName("Test select * from table Permis")
    public void findAllPermis() {
        assertEquals(1, permisRepository.findAll().get(0).getIdPermis());
    }

    @Test
    @Disabled
    @DisplayName("Test select * from user where login =?")
    public void findUserByLogin(){
        assertNotNull(userRepository.findUserByLogin("Toto"));
    }

    @Test
    public void testLogin(){

    }
}
