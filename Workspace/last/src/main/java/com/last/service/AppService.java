package com.last.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class AppService {

    public static boolean genererQR(String data){
        Path path = FileSystems.getDefault().getPath("./qrCode.PNG");
        QRCodeWriter qr = new QRCodeWriter();
        try {
            //Integer.parseInt(environment.getProperty(300)),Integer.parseInt(environment.getProperty("qrCode.height"))), environment.getProperty("qrCode.format")
            MatrixToImageWriter.writeToPath(qr.encode(data, BarcodeFormat.QR_CODE,300, 300), "PNG", path);
        } catch (IOException | WriterException e) {
            return false;
        }
        return true;
    }
}
