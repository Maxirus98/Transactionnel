package com.mysql.rencontre07.services;

import com.mysql.rencontre07.models.User;

public class MyService {
    //TDD copier coller les paramètres de l'assertions
    public static boolean login(User u, String inputLogin, String inputPwd){
        u.setLogin(inputLogin);
        u.setPassword(inputPwd );
        return u.getLogin().equals(inputLogin) && u.getPassword().equals(inputPwd);
    }
}
