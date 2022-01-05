package com.ministeretp.controller;

import com.ministeretp.model.Citoyen;
import com.ministeretp.repository.CitoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4220")
public class CitoyenController {
    @Autowired
    CitoyenRepository citoyenRepository;

    @GetMapping("/ministere/{nassm}")
    public Citoyen isCitoyenValid(@PathVariable String nassm){
        return citoyenRepository.findByNassm(nassm);

    }
}
