package com.mysql.rencontre07;

import com.mysql.rencontre07.models.Permis;
import com.mysql.rencontre07.models.User;
import com.mysql.rencontre07.repositories.PermisRepository;
import com.mysql.rencontre07.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class InsertData implements CommandLineRunner {
    @Autowired
    PermisRepository permisRepository;
    @Autowired
    UserRepository repository;

    private void insert() {
        User u = new User();
        Permis p = new Permis(); p.setTypePermis("VACCIN");
        u.setLogin("Toto"); u.setPassword("toto1234"); u.setPermis(p);

        User u1 = new User();
        Permis p1 = new Permis(); p1.setTypePermis("TEST");
        u1.setLogin("Tata"); u1.setPassword("tata1234"); u1.setPermis(p1);

        Permis p2 = new Permis(); p2.setTypePermis("TEST");
        Permis p3 = new Permis(); p3.setTypePermis("VACCIN");
        Permis p4 = new Permis(); p4.setTypePermis("TEST");

        List<Permis> permisData = Arrays.asList(p, p1, p2, p3, p4);
        this.permisRepository.saveAll(permisData);

        List<User> userData = Arrays.asList(u, u1);
        this.repository.saveAll(userData);
    }

    private void cleanData(){
        this.permisRepository.deleteAll();
        this.repository.deleteAll();
    }

    @Override
    public void run(String... args) throws Exception {
        cleanData();
        insert();
    }
}
