package com.p4.permissante;

import com.p4.permissante.repository.PermisRepository;
import lombok.extern.java.Log;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
@Log
public class PermisSanteApplication {

    @Autowired
    PermisRepository permisRepository;
    public static void main(String[] args) {
        SpringApplication.run(PermisSanteApplication.class, args);
    }

    //Habituellement a 6h du matin
    @Scheduled(cron = "0 56 15 * * *")
    public void doSomething(){
        log.info("Number of updated Record ==> " + permisRepository.changePermisStatus(LocalDate.now()));
    }
}
