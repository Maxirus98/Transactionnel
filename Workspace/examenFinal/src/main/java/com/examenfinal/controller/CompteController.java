package com.examenfinal.controller;

import com.examenfinal.model.Compte;
import com.examenfinal.model.Epargne;
import com.examenfinal.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {

    @Autowired
    CompteRepository repository;


    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Compte> trouverUnCompte(){
        return repository.findAll();
    }

    @RequestMapping(path = "all/comptes", method = RequestMethod.GET)
    public Compte trouverUnCompte(@RequestParam int id){
        return repository.findCompteById(id);
    }

    @PostMapping(path = "all/comptes")
    public Compte ouvrirUnCompte(@RequestBody Compte compte){
       return repository.save(compte);
    }

    @PostMapping(path = "all/comptes/epargne")
    public Compte ouvrirUnCompteEpargne(@RequestBody Epargne compte){
        return repository.save(compte);
    }

    @PostMapping(path = "/all")
    public Compte ajouterTousLesComptes(@RequestBody Compte compte){
        return repository.save(compte);
    }

    //Not tested
    @RequestMapping(path = "/all", method = RequestMethod.DELETE)
    public void supprimerCompte(@RequestParam int id){
        repository.deleteById(id);
    }
}
