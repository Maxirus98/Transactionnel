package com.admin2.repository;

import com.admin2.model.Permis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PermisRepository extends JpaRepository<Permis, Integer> {
    List<Permis> findByDateDebutBefore(LocalDate date);
    Permis findPermisByCitizen_CourrielAndCitizen_Password(String input1, String input2);

    @Transactional
    @Modifying //Modifié l'état de la BD, :date doit être la même chose que le Param date
    @Query("update Permis p set p.expired = true where p.dateFin < :date") // Requête SQL, instancié le permis ici
    int desactivePermis(@Param("date") LocalDate date);

    @Transactional
    @Modifying
    @Query("update Permis p set p.expired = false where p.dateFin = :date")
    int changePermisStatus(@Param("date") LocalDate date);
}
