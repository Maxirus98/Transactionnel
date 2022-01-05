package com.example.ministerews.controller;

import com.example.ministerews.repository.CitoyenRepository;
import com.example.ministerews.service.MinistereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinistereController {

    @Autowired
    CitoyenRepository citoyenRepository;

    // UN OU L'AUTRE

    @Autowired
    MinistereService ministereService;

    //Méthode directement avec le repo
    @GetMapping("/ministere/{num}") // chemin écris après le nom de domaine
    public boolean checkCitizenValidity(String num){
        return citoyenRepository.findCitoyenByNumero(num).isValid();
    }

    //Méthode avec repo cacher
    @GetMapping("")
    public boolean checkCitizenValidity2(String num){
        return ministereService.validerNassmCitoyen(num);
    }
}
