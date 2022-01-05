package com.example.rencontre06.repository;

import com.example.rencontre06.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Spring Data JPA (Vert schéma)
    //sert a faire les methodes insert...
}
