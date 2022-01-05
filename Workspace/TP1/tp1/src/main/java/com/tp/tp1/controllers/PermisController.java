package com.tp.tp1.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.tp.tp1.models.Citoyen;
import com.tp.tp1.models.Permis;
import com.tp.tp1.models.PermisTest;
import com.tp.tp1.repository.PermisRepository;
import com.tp.tp1.repository.UserRepository;
import com.tp.tp1.services.PermisService;
import com.tp.tp1.services.SystemService;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4220")
public class PermisController {
    @Autowired
    PermisRepository permisRepository;

    @Autowired
    UserRepository citoyenRepository;

    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/permisSantePermis", method = RequestMethod.GET)
    public Permis getPermis(@RequestParam(value="courriel") String courriel, @RequestParam(value="pwd") String pwd){
        return permisRepository.findPermisByCitoyen_CourrielAndCitoyen_Password(courriel, pwd);
    }

    @PostMapping("/permisSantePermis")
    public Permis genererPermis (@RequestBody Permis permis) {
        if (saveValidCitoyenOfPermis(permis) != null) {
                PermisService.setCodeQR(permis);
                //SMTP doit être configuré username et mot de passe
                //genererEtEnvoyerCourriel(permis);
                return permisRepository.save(permis);
        }
        return null;
    }

    @RequestMapping(value = "/permisSantePermis/test", method = RequestMethod.POST)
    public PermisTest genererPermis (@RequestBody PermisTest permis){
        if (saveValidCitoyenOfPermis(permis) != null) {
            PermisService.setCodeQR(permis);
            //SMTP doit être configuré username et mot de passe
            //genererEtEnvoyerCourriel(permis);
            return permisRepository.save(permis);
        }
        return  null;
    }

    //Référence: Cours 420-445
    @GetMapping("/permisSantePermis/qrCode/{id}")
    public void getQrCodeByIdPermis(@PathVariable int id, HttpServletResponse response) throws IOException{
        response.setContentType("image/jpeg");

        InputStream is = new ByteArrayInputStream(permisRepository.findPermisByIdPermis(id).getQrBitMap());
        IOUtils.copy(is, response.getOutputStream());
    }

    private Permis saveValidCitoyenOfPermis(Permis permis){
        final String uri = "http://localhost:9595/ministere/";
        RestTemplate restTemplate = new RestTemplate();
        Citoyen citoyen = restTemplate.getForObject(uri + permis
                .getCitoyen().getNassm(), Citoyen.class);

        if (citoyen != null) {
            permis.setCitoyen(citoyen);
            return permis;
        }
        return null;
    }

    //SMTP doit être configuré username et mot de passe
    private void genererEtEnvoyerCourriel(Permis permis){
        SystemService.genererQR(permis.toString());
        SystemService.genererPDF();
       try {
            systemService.envoyerCourriel(permis.getCitoyen().getCourriel(), "Votre Permis: " + permis.getIdPermis(),
                    "Votre permis de vaccination n'expire pas. Enregistrez le dans vos dossiers.", true);
       } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/permisSantePermis/test", method = RequestMethod.GET)
    public PermisTest getPermisTest(@RequestParam(value="courriel") String courriel, @RequestParam(value="pwd") String pwd){
        return permisRepository.findPermisTestByCitoyen_CourrielAndCitoyen_Password(courriel, pwd);
    }

    @RequestMapping(value = "/permisSantePermis/test", method = RequestMethod.PUT)
    public PermisTest renouvellerPermis (@RequestParam(value="ID_PERMIS") int id){
        PermisTest permis = permisRepository.findPermisTestByIdPermis(id);
        PermisService.renouvellerPermisTest(permis);
        return permisRepository.save(permis);
    }
}
