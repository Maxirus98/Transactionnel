package ministere.demo.controller;

import ministere.demo.model.Citoyen;
import ministere.demo.repository.CitoyenRepository;
import ministere.demo.service.MinistereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4220")
public class MinistereController {
    @Autowired
    MinistereService service;
    @Autowired
    CitoyenRepository citoyenRepository;

    @GetMapping("/ministere/{nassm}")
    public Citoyen checkCitizenValidity(@PathVariable String nassm){
        return citoyenRepository.findByNassm(nassm);

    }
}
