package com.example.mobile;

import com.example.mobile.model.Country;
import com.example.mobile.repository.CountryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class MobileApplication implements CommandLineRunner {
    //Comment déployé, il faut compiler le projet pour donner un fichier executable jar
    @Autowired
    CountryRepository countryRepository;
    public static void main(String[] args) {
        SpringApplication.run(MobileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>() {};
        try{
            File file = new File("./capital.json");
            List<Country> countries = objectMapper.readValue(file, typeReference);
            countryRepository.saveAll(countries);
        }catch (FileNotFoundException notFoundException) {
            notFoundException.printStackTrace();
        }
    }
}
