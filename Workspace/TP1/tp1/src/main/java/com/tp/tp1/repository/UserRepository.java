package com.tp.tp1.repository;

import com.tp.tp1.models.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Citoyen, Integer> {
    public Citoyen findCitoyenByCourrielAndPassword(String input1, String input2);
    public Citoyen findCitoyenByCourrielAndPasswordOrNassm(String input1, String input2, String input3);
    Citoyen findCitoyenByCourrielOrPassword(String input1, String input2);
    Citoyen findCitoyenByCourriel(String input1);
    public Integer deleteCitoyenByCourrielAndPassword(String input1, String input);
    public Citoyen findCitoyenById(int id);
    public Citoyen findCitoyenByNassm(String nassm);
}
