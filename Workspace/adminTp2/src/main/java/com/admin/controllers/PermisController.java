package com.admin.controllers;

import com.admin.models.Citoyen;
import com.admin.models.Permis;
import com.admin.models.PermisTest;
import com.admin.repositories.PermisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8484"})
public class PermisController {

    @Autowired
    PermisRepository repository;

    @GetMapping("/permisSantePermis")
    public List<Permis> findAllPermis(){
        return repository.findAll();
    }

    @GetMapping("/permisSantePermis/{id}")
    public Permis findPermisByID(@PathVariable("id") int id){
        return repository.findPermisByIdPermis(id);
    }

    @GetMapping("/permisSantePermis/test")
    public PermisTest findPermisTestByID(@RequestParam("ID_PERMIS") int id){
        return repository.findPermisTestByIdPermis(id);
    }

    @Transactional
    @Modifying
    @DeleteMapping("/permisSantePermis")
    public Integer deletePermisById(@RequestParam(value="ID_PERMIS") int id){
        return repository.deletePermisByIdPermis(id);
    }

    @RequestMapping(value = "/permisSantePermis/test", method = RequestMethod.PUT)
    public PermisTest renouvellerPermis (@RequestParam(value="ID_PERMIS") int id){
        PermisTest permis = repository.findPermisTestByIdPermis(id);
        permis.setDateDebut(LocalDate.now());
        permis.setDateFin(LocalDate.now().plusDays(PermisTest.PLUS_DAYS));
        return repository.save(permis);
    }
}
