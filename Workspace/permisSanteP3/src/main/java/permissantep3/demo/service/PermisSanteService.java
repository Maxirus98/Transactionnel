package permissantep3.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PermisSanteService {
   // Logger logger = LoggerFactory.getLogger(PermisSante.class);
    public String getCitizenValidity(String input){
        final String url ="http://localhost:8282/ministere/";
        RestTemplate restTemplate = new RestTemplate();
        //Ce qu'on veut retourner est le retour de la méthode du MinistereController de l'autre projet
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(url+input, Boolean.class);

        return responseEntity.getBody().toString();
    }
}
