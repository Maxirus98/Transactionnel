package com.example.phase02;

import com.example.phase02.services.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Phase02Application implements CommandLineRunner {
    @Autowired
    SystemService service;

    public static void main(String[] args) {
        SpringApplication.run(Phase02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //service.envoyerCourriel("dupuismaxime@hotmail.com", "Test coding permis santé", "C'est juste pour tester");
    }
}
