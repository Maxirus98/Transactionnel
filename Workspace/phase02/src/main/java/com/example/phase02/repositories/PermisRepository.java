package com.example.phase02.repositories;

import com.example.phase02.models.Permis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PermisRepository extends JpaRepository<Permis, Integer> {
        public List<Permis> findByDateExpiration(Date dateExpiration);
        public Integer countPermisByTypePermis(String typePermis);
}
