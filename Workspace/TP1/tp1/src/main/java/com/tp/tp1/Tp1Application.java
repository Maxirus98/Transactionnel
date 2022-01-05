package com.tp.tp1;

import com.tp.tp1.repository.PermisRepository;
import com.tp.tp1.services.SystemService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

@SpringBootApplication
public class Tp1Application implements CommandLineRunner {
    @Autowired
    SystemService service;
    @Autowired
    PermisRepository permisRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //service.envoyerCourriel("dupuismaxime@hotmail.com", "Test email", "Message");
    }

    @Scheduled( cron="0 30 15 ? * *")
    public void expirerLePermis(){
        permisRepository.desactivePermis(LocalDate.now());
    }
}
