package com.tp.tp1.services;

import com.tp.tp1.repository.PermisRepository;
import com.tp.tp1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    //Devront être testé lorsque Minisètre sera fait
    public boolean seConnecter(String input1, String input2) {
        //ajouter condition ministere
        return userRepository.findCitoyenByCourrielAndPassword(input1, input2) != null;
    }
    public boolean sInscrire(String input1, String input2) {
        return userRepository.findCitoyenByCourrielAndPassword(input1, input2) == null;
    }


}
