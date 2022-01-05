package permissantep3.demo;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import permissantep3.demo.repository.PermisRepository;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
@Log
public class DemoApplication {
    @Autowired
    private PermisRepository permisRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //cron = "secondes, minutes, jours, mois, ...
    @Scheduled( cron="0 56 15 ? * *")
    public void doSomething(){
       // log.info("Processus Task Scheduler...");
        permisRepository.changePermisStatus(LocalDate.now());
    }


}
