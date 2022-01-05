package com.examenfinal.repositories;

import com.examenfinal.model.Compte;
import com.examenfinal.model.Epargne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    public Compte findCompteById(int id);
    public Epargne findEpargneById(int id);
}
