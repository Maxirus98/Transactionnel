package com.ministeretp.repository;

import com.ministeretp.model.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitoyenRepository extends JpaRepository<Citoyen,Integer> {
    Citoyen findByNassm(String nassm);
}
