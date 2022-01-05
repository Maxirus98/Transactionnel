package ministere.demo.service;

import ministere.demo.repository.CitoyenRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

//Objet auquel Spring va accorder une importance particulière
@Service
public class MinistereService
{
    Logger logger;
    @Autowired
    CitoyenRepository repository;
    @GetMapping("/ministere/{nassm}")
    public boolean checkCitizenValidity(@PathVariable String nassm){
        boolean flag = false;
        try{
        if(repository.findByNassm(nassm) != null) {
            flag = true;
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
