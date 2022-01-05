package com.admin.repositories;

import com.admin.models.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitoyenRepository extends JpaRepository<Citoyen, Integer> {
    public Citoyen deleteCitoyenById(int id);
}
