package permissantep3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import permissantep3.demo.model.Citizen;
import permissantep3.demo.model.Permis;
import permissantep3.demo.repository.CitizenRepository;
import permissantep3.demo.repository.PermisRepository;
import permissantep3.demo.service.MinistereService;

@RestController
@CrossOrigin(origins = "http://localhost:4220")
public class PermisSanteController {
    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    PermisRepository permisRepository;

    @RequestMapping(value = "/permisSante", method = RequestMethod.GET)
    public Citizen login(@RequestParam(value="courriel") String courriel, @RequestParam(value="pwd") String pwd){
        return citizenRepository.findCitizenByCourrielAndPassword(courriel, pwd);
    }

    @RequestMapping(value = "/permisSante", method = RequestMethod.POST)
    public Citizen subscribe (@RequestBody Citizen citizen){
        return citizenRepository.save(citizen);
    }

    @RequestMapping(value = "/permisSantePermis", method = RequestMethod.GET)
    public Permis getPermis(@RequestParam(value="courriel") String courriel, @RequestParam(value="pwd") String pwd){
        return permisRepository.findPermisByCitizen_CourrielAndCitizen_Password(courriel, pwd);
    }

    @RequestMapping(value = "/permisSantePermis", method = RequestMethod.POST)
    public Permis genererPermis (@RequestBody Permis permis){
        return permisRepository.save(permis);
    }
}
