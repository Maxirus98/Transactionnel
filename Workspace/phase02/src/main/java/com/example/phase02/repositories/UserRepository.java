package com.example.phase02.repositories;

import com.example.phase02.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//find
//exists
//delete
//count
@Repository //Possibilité de lancer des requetes SQL sans avoir a les créer
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByLogin(String login);
    public User findUserByLoginIgnoreCase(String login);
    public User findUserByLoginIgnoreCaseAndPassword(String login, String pwd);
}
