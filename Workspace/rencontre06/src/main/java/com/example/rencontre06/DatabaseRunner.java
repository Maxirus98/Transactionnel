package com.example.rencontre06;

import com.example.rencontre06.models.Admin;
import com.example.rencontre06.models.User;
import com.example.rencontre06.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//Exécuter sans être appelé: en priorité
@Component
public class DatabaseRunner implements CommandLineRunner {
    //Apporter toutes les méthodes ,car on ne peut pas instancier une interface
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setLogin("user@user.com");
        user.setPassword("password123");

        Admin admin = new Admin();
        admin.setLogin("admin@admin.com");
        admin.setPassword("passwordAdmin");
        admin.setRole("Gerant Front-End");

        List<User> liste = new ArrayList();
        liste.add(user);
        liste.add(admin);

        repository.saveAll(liste);

    }
}
