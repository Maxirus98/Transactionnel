package com.p4.permissante.repository;

import com.p4.permissante.model.Permis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface PermisRepository extends JpaRepository<Permis, Integer> {
    List<Permis> findByDateDebutBefore(LocalDate date);

    //Puller pour désactiver les permis périmé
    @Transactional
    @Modifying
    @Query("update Permis p set p.expired = true where p.dateFin < :date")
    int desactivePermis(@Param("date") LocalDate date);

    @Transactional
    @Modifying
    @Query("update Permis p set p.expired = true where p.dateFin < :date")
    int changePermisStatus(@Param("date") LocalDate date);
}
