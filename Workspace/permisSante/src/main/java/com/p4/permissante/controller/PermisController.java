package com.p4.permissante.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.p4.permissante.model.Citizen;
import com.p4.permissante.model.Permis;
import com.p4.permissante.repository.CitizenRepository;
import com.p4.permissante.repository.PermisRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4220", "http://localhost:4444"}) //{} pour plusieurs origines
public class PermisController {
    // Va communiquer avec le Ministere, il va rendre disponible les méthodes des repositories

    @Autowired
    PermisRepository permisRepository;

    @Autowired
    CitizenRepository citizenRepository;

    @PostMapping(value = "/permisSante/request1")
    public Permis genererPermis(@RequestBody Permis permis) throws Exception {
        //Pour appeler le ministère
        //WS avec cross origin aussi
        final String uri = "http://localhost:9595/ministere/";
        //SpringBoot qui appelle au autre spring boot
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Citizen> responseEntity = restTemplate.getForEntity(uri+permis.getNassm(), Citizen.class);

        if(responseEntity.getBody() instanceof  Citizen && responseEntity.getBody() != null) {
            //Récupérer le citizen du ministère
            citizenRepository.save(responseEntity.getBody());
            permis.setCitizen(responseEntity.getBody());

            //Générer le Qr
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BufferedImage qrCode =
                    MatrixToImageWriter.toBufferedImage(qrCodeWriter.encode(responseEntity.getBody().getNassm(), BarcodeFormat.QR_CODE, 100,  100));

            //Transformée le QR en tablau de byte
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //Pouvoir le stocké dans une bd
            ImageIO.write(qrCode, "jpg", baos);
            baos.flush();
            permis.setQrCode(baos.toByteArray());
        }
        return permisRepository.save(permis);
    }

    @GetMapping("/permisSante/qrCode/{id}")
    public void getQrCodeByIdPermis(@PathVariable int id,
                                    HttpServletResponse response) throws IOException {
        response.setContentType("images/jpeg");
        Permis permis = permisRepository.getOne(id);

        //Appeler l'url dans le src d'une img dans html
        InputStream is = new ByteArrayInputStream(permis.getQrCode());
        IOUtils.copy(is, response.getOutputStream());

        //On ne retourne rien car ce n'est uqe l'Affichage
    }

    @GetMapping("permisSante/GetAll")
    public List<Permis> getAll() {
        return permisRepository.findAll();
    }
}
