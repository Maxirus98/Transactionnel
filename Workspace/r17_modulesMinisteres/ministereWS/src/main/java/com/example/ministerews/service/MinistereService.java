package com.example.ministerews.service;

import com.example.ministerews.repository.CitoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinistereService {
    @Autowired
    CitoyenRepository citoyenRepository;

    public boolean validerNassmCitoyen(String num){
        return citoyenRepository.findCitoyenByNumero(num).isValid();
    }
}
