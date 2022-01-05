package com.last.dataLogger;

import com.last.model.Permis;
import com.last.repository.PermisRepository;
import com.last.service.AppService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PermisRepository permisRepostory;


    @Override
    public void run(String... args) throws Exception {
        Permis p1 = new Permis();
        p1.setTypePermis("Vaccin"); p1.setRegion("MTL");
        AppService.genererQR(p1.toString());
        FileInputStream fis = new FileInputStream("./qrCode.PNG");
        p1.setCodeQR(IOUtils.toByteArray(fis));

        Permis p2 = new Permis();
        p2.setTypePermis("Test"); p2.setRegion("MTL");p2.setExpired(true);
        FileInputStream fis2 = new FileInputStream("./qrCode.PNG");
        p2.setCodeQR(IOUtils.toByteArray(fis));

        permisRepostory.saveAll(Arrays.asList(p1, p2));

    }
}
