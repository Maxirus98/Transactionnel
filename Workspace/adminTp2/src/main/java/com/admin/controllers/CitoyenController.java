package com.admin.controllers;

import com.admin.models.Citoyen;
import com.admin.repositories.CitoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8484"})
public class CitoyenController {
    @Autowired
    CitoyenRepository repository;

    @Transactional
    @Modifying
    @DeleteMapping("/permisSante")
    public Citoyen deleteCitoyenById(@RequestParam(value="ID") int id){
        return repository.deleteCitoyenById(id);
    }


}
