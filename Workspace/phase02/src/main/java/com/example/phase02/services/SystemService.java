package com.example.phase02.services;

import com.example.phase02.models.Permis;
import com.example.phase02.repositories.PermisRepository;
import com.example.phase02.repositories.UserRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermisRepository permisRepository;
    @Autowired(required = false)
    private JavaMailSender mailSender;
    //Vient du fichier properties
    @Autowired
    private static Environment environment;

    //Savoir si le login existe deja
    public boolean login(String str1, String str2) {
        return userRepository.findUserByLoginIgnoreCaseAndPassword(str1, str2) != null;
    }

    public boolean isLoginExist(String str) {
        return userRepository.findUserByLoginIgnoreCase(str) != null;
    }

    public List<Permis> AllPermis(){
        return permisRepository.findAll();
    }

    public static void genererQR(String data, String filePath) throws Exception{
        Path path = FileSystems.getDefault().getPath(filePath);
        QRCodeWriter qr = new QRCodeWriter();

        MatrixToImageWriter.writeToPath(qr.encode(data, BarcodeFormat.QR_CODE, Integer.parseInt(environment.getProperty("qrCode.width")),Integer.parseInt(environment.getProperty("qrCode.height"))), environment.getProperty("qrCode.format"), path);
    }

    public static void genererPDF(String filePath) throws Exception{
        //Stylo
        PdfWriter pdfWriter = new PdfWriter(PATH_PDF);
        //Feuille blanc
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        //Document type document
        Document document = new Document(pdfDocument);
        //Ajouter Image
        Image image = new Image(ImageDataFactory.create(PATH_QR));
        //Ajouter texte et image au paragraphe
        Paragraph paragraph = new Paragraph("HARDCODED TITLE \n")
                .add("Hardcoded Added String")
                .add(image);
        //Ajouter paragraphe au document
        document.add(paragraph);
        document.close();
    }

    public void envoyerCourriel(String courrielDestinataire, String sujet, String message) throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //Créer fenêtre
        //Va chercher les proprités sujet, titre, corps, destinataire, attachement...
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(courrielDestinataire);
        helper.setSubject(sujet);
        helper.setText(message);
        helper.addAttachment("QR_CODE", new File(PATH_QR));
        helper.addAttachment("QR_CODE_PDF", new File(PATH_PDF));

        mailSender.send(mimeMessage);
    }

    //Créer un QR
    /*public static void main(String[] args) throws Exception {
        genererQR("123456g121214;user;email;514-555-5555;", PATH_QR);
        genererPDF(PATH_PDF);
    }*/
}
