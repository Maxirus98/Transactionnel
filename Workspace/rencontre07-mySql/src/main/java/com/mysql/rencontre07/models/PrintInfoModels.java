package com.mysql.rencontre07.models;

import java.sql.SQLOutput;
import java.util.List;

public class PrintInfoModels {

    public static void print(List<User> users){
        String header = String.format("%-12s %-12s %-12s %-12s %s", "ID", "LOGIN", "PWD", "TYPE", "DESC");
        System.out.println(header);

        for(User u : users){
            String data = String.format("%-12s %-12s %-12s %s",
                    u.getId(),
                    u.getLogin(),
                    u.getPassword(),
                    u.getPermis().getTypePermis());
            System.out.println(data);
        }
        System.out.println();
    }

    public static void printPermis(List<Permis> permis){
        String header = String.format("%-12s %-12s %s", "ID", "TYPE", "DESC");
        System.out.println(header);

        for(Permis p : permis){
            String data = String.format("%-12s %s",
                    p.getId(),
                    p.getTypePermis());
            System.out.println(data);
        }
        System.out.println();
    }
}
