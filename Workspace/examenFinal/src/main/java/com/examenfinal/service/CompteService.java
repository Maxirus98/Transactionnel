package com.examenfinal.service;

import com.examenfinal.repositories.CompteRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
public class CompteService {

    private final static String PATH_QR = "./nouveauQr.QR";

    @Autowired
    CompteRepository repository;

    public void genererQR(String data){
        Path path = FileSystems.getDefault().getPath(PATH_QR);
        QRCodeWriter qr = new QRCodeWriter();
        try {
            MatrixToImageWriter.writeToPath(qr.encode(data, BarcodeFormat.QR_CODE,300, 300), "PNG", path);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
    }

}
