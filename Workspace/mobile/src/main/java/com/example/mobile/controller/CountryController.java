package com.example.mobile.controller;

import com.example.mobile.model.Country;
import com.example.mobile.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
//Controller lorsqu'on donne un service, service lorsqu'on utilise un service (ex: findBy)
@RestController
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @RequestMapping(value="/countries", method = RequestMethod.GET)
    public Collection<Country> getAll(){
        return countryRepository.findAll();
    }
    @RequestMapping(value="/countries2", method = RequestMethod.GET)
    public Collection<Country> getAll2(){
        return countryRepository.findAll();
    }
}
