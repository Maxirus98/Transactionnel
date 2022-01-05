package com.last.repository;

import com.last.model.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitoyenRepository extends JpaRepository<Citoyen, Integer> {

    Citoyen findCitoyenByCourriel(String input1);


}
