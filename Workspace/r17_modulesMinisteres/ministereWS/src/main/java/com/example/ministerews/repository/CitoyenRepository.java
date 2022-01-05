package com.example.ministerews.repository;

import com.example.ministerews.model.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitoyenRepository extends JpaRepository<Citoyen, Integer> {
    public Citoyen findCitoyenByNumero(String num);
}
