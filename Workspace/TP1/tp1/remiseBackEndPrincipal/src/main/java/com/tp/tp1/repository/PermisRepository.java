package com.tp.tp1.repository;

import com.tp.tp1.models.Citoyen;
import com.tp.tp1.models.Permis;
import com.tp.tp1.models.PermisTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface PermisRepository extends JpaRepository<Permis, Integer> {
    public Permis findPermisByCitoyen_CourrielAndCitoyen_Password(String input1, String input2);
    public PermisTest findPermisTestByCitoyen_CourrielAndCitoyen_Password(String input1, String input2);
    public Integer deletePermisByCitoyen_CourrielAndCitoyen_Password(String input1, String input2);
    public PermisTest findPermisTestByIdPermis(int input1);
    public Permis findPermisByIdPermis(int input1);

    @Transactional
    @Modifying
    @Query(value = "update PermisTest p set p.expired = true where p.dateFin < :date")
    int desactivePermis(@Param("date") LocalDate date);

    @Transactional
    @Modifying
    @Query(value = "update PermisTest p set p.expired = false, p.dateDebut = :dateDebut , p.dateFin = :dateFin")
    int renouvellerPermis(@Param("dateDebut") LocalDate dateDebut, @Param("dateFin") LocalDate dateFin);




}



