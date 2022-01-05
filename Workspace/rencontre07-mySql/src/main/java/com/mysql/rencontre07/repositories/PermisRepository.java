package com.mysql.rencontre07.repositories;

import com.mysql.rencontre07.models.Permis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisRepository extends JpaRepository<Permis, Integer> {
    //demander les méthodes de JPA à l'aide du nom de la méthode

}
