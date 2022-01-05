package com.mysql.rencontre07;

import com.mysql.rencontre07.models.User;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mysql.rencontre07.services.MyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
public class UsecasesTest{
    @Test //Test JUNIT 4 ou 5. SI dependences ajoutées dans POM.XML
    @DisplayName("Usecase01= login") //Pour différencier les tests
    public void testUC1(){
     //Un test unitaire test le code d'une methode peu importe les données
        //Arrange Preparer les données
        //Act : Appeler la méthode
        //Assert : Assert les retours de methode
        User user1 = new User();
        final String inputLogin = "toto";
        final String inputPwd = "toto1234";

        //Act
        //Assert
        assertTrue(MyService.login(user1, inputLogin, inputPwd));
    }
}
