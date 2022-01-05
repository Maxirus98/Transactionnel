package com.mysql.rencontre07;

import com.mysql.rencontre07.models.Permis;
import com.mysql.rencontre07.models.PrintInfoModels;
import com.mysql.rencontre07.models.User;
import com.mysql.rencontre07.repositories.PermisRepository;
import com.mysql.rencontre07.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2) //Décide de la priorité entre Componenent(BEAN) qui sont de meme priorité par defaut
public class RunQueries implements CommandLineRunner {

    @Autowired
    PermisRepository permisRepository;
    @Autowired
    UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("----\nQuery: findAll");
        List<User> list1 = this.repository.findAll();
        System.out.println(list1);
        //PrintInfoModels.print(list1);

        System.out.println("----\nQuery: findById");
        User user1 = this.repository.findById(1);
        System.out.println(user1);

        System.out.println("----\nQuery: findByLoginAndPassword");
        User user2 = this.repository.findUserByLoginAndPassword("Tata", "tata1234");
        System.out.println(user2);

        /*System.out.println("----\nQuery: findById getOne");
        Permis p1 = this.permisRepository.getOne(1);
        System.out.println(p1);*/
    }
}
