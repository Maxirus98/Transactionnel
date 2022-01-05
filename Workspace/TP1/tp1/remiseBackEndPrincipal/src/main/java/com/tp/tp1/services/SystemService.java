package com.tp.tp1.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import com.tp.tp1.repository.PermisRepository;
import com.tp.tp1.repository.UserRepository;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

//Va masquer les méthodes du Repository
@Service
public class SystemService {
    private final static String PATH_PDF = "./nouveauQr.pdf";
    private final static String PATH_QR = "./nouveauQr.QR";

    /*
     *
     * INJECTIONS
     *
     * */
    @Autowired(required = false)
    private JavaMailSender mailSender;

    //Pas standard*
    public static boolean genererQR(String data){
        Path path = FileSystems.getDefault().getPath(PATH_QR);
        QRCodeWriter qr = new QRCodeWriter();
        try {
            //Integer.parseInt(environment.getProperty(300)),Integer.parseInt(environment.getProperty("qrCode.height"))), environment.getProperty("qrCode.format")
            MatrixToImageWriter.writeToPath(qr.encode(data, BarcodeFormat.QR_CODE,300, 300), "PNG", path);
        } catch (IOException | WriterException e) {
            return false;
        }
        return true;
    }

    //Pas standard*
    public static boolean genererPDF(){
        //Stylo
        try{
            PdfWriter pdfWriter = new PdfWriter(PATH_PDF);
            //Feuille blanc
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);

            //Document type document
            Document document = new Document(pdfDocument);
            //Ajouter Image
            Image image = new Image(ImageDataFactory.create(PATH_QR));
            //Ajouter texte et image au paragraphe
            Paragraph paragraph = new Paragraph("Votre Permis " +  "\n")
                    .add("Pandémie du Coronavirus")
                    .add(image);
            //Ajouter paragraphe au document
            document.add(paragraph);
            document.close();
        }catch (FileNotFoundException | MalformedURLException fileNotFoundException){
            return false;
        }
        return true;
    }

    //Pas standard
    public void envoyerCourriel(String courrielDestinataire, String sujet, String message, boolean attachement) throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(courrielDestinataire);
        helper.setSubject(sujet);
        helper.setText(message);
        if(attachement) {
            helper.addAttachment("QR_CODE", new File(PATH_QR));
            helper.addAttachment("QR_CODE_PDF", new File(PATH_PDF));
        }
        mailSender.send(mimeMessage);
    }
}
