package com.tp.tp1.controllers;

import com.tp.tp1.models.Citoyen;
import com.tp.tp1.repository.UserRepository;
import com.tp.tp1.services.SystemService;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@CrossOrigin(origins = "http://localhost:4220")
public class CitoyenController {
    @Autowired
    UserRepository citoyenRepository;

    @RequestMapping(value = "/permisSante", method = RequestMethod.GET)
    public Citoyen login(@RequestParam(value="courriel") String courriel, @RequestParam(value="pwd", required = false) String pwd){
        return citoyenRepository.findCitoyenByCourrielAndPassword(courriel, pwd);
    }

    // Citoyen is saved even when no permis are saved
    @RequestMapping(value = "/permisSante", method = RequestMethod.POST)
    public Citoyen subscribe (@RequestBody Citoyen citizen, @RequestParam(value="courriel") String courriel, @RequestParam(value="pwd") String pwd){
        if(citoyenRepository.findCitoyenByCourrielOrPassword(courriel, pwd) != null) {
            return null;
        }
        return citoyenRepository.save(citizen);
    }

    //Note: Le username et le mot de passe pour le serveur SMTP n'est pas configuré dans le application.properties
    // Sans configuration, la vérification par courriel ne s'effectue pas et on ne peut créer d'enfant.
    @RequestMapping(value = "/permisSante/tuteurValid", method = RequestMethod.POST)
    public Citoyen sendEmailValidationTuteur (@RequestBody Citoyen citizen, String courriel, String message){
        try {
            SystemService systemService = new SystemService();
            systemService.envoyerCourriel(courriel, "Code de vérification de tuteur", message, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citoyenRepository.save(citizen);
    }

    @RequestMapping(value = "/permisSante/tuteurValid", method = RequestMethod.GET)
    public Citoyen getEmailValidationTuteur (@RequestParam(value="courriel") String courriel){
        return citoyenRepository.findCitoyenByCourriel(courriel);
    }
}
