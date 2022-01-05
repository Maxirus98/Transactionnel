package com.tp.tp1.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.tp.tp1.models.Permis;
import com.tp.tp1.models.PermisTest;
import com.tp.tp1.repository.PermisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
@Service
public class PermisService {

    public static final int DIMENSION = 100;
    @Autowired
    private PermisRepository permisRepository;
    public boolean permisExiste(String input1, String input2){
        return permisRepository.findPermisByCitoyen_CourrielAndCitoyen_Password(input1, input2) != null;
    }

    public boolean permisActif(String input1, String input2){
        return permisRepository.findPermisTestByCitoyen_CourrielAndCitoyen_Password(input1, input2).getDateFin().isAfter(LocalDate.now());
    }

    //NOT DRY
    public static void setCodeQR(Permis permis){
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BufferedImage qrCode =
                    MatrixToImageWriter.toBufferedImage(qrCodeWriter.encode(permis.getCitoyen().toString(),
                            BarcodeFormat.QR_CODE, PermisService.DIMENSION, PermisService.DIMENSION));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrCode, "jpg", baos);
            baos.flush();
            permis.setQrBitMap(baos.toByteArray());
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
    }

    public static void renouvellerPermisTest(PermisTest permis){
        permis.setDateDebut(LocalDate.now());
        permis.setDateFin(permis.getDateDebut().plusDays(15));
        permis.setExpired(false);

    }
}
