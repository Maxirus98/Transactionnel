package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    //Déclaration polymorphique
    //ctrl-shift arrow-up pour monter une seule ligne
    private List<User> list = new ArrayList<>();

    public List<User> getList() {
        return list;
    }
    public void setList(List<User> list) {
        this.list = list;
    }

    //Stocker dans un fichier XML
    public static boolean saveXML(String filename, List<User> list){
        boolean flag = false;
        XStream stream = new XStream();
        try {
            //Cacher l'objet List du fichier XML
            stream.alias("ListeUsers", list.getClass());
            stream.alias("User", User.class);
            //Changer la liste de user en format XML
            stream.toXML(list, new FileOutputStream(filename));
            //Si le fichier existe( a été créé)
            flag = new File(filename).exists();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }
    public static List<User> readXML(String filename){
        List<User> list = new ArrayList<>();
        XStream stream = new XStream();
        try {
            //Lire ce qui est écrit avec les mêmes alias de balise
            stream.alias("ListeUsers", List.class);
            stream.alias("User", User.class);
            list = (List<User>)stream.fromXML(new FileInputStream(filename));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    //Il manque readJSON
    public static boolean saveJSON(String filename, List<User> list){
        boolean flag = false;
        //Créer la structure pretty du fichier JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            //Écrire la liste dans le fichier
            //Buffer
            Writer writer = new FileWriter(filename);
            //Convertir en fichier json
            gson.toJson(list, writer);
            //Vider le contenu de writer dans le fichier spécifié
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Changer la liste de user en format JSON
        gson.toJson(list);

        return flag;
    }

    public static void main(String[] args) {
        User u1 = new User(1,"to", 210000f);
        User u2 = new User(2,"ti", 220000f);
        User u3 = new User(3,"ta", 230000f);
        User u4 = new User(4,"tu", 240000f);
        User u5 = new User(5,"teu", 250000f);

        List<User> liste = new ArrayList<>();
        liste.add(u1);liste.add(u2);liste.add(u3);liste.add(u4);liste.add(u5);
        saveJSON("./users.json", liste);
        //saveXML("./users.xml", liste);
        System.out.println(readXML("./users.xml"));
    }
}
