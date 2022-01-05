package com.admin.repositories;

import com.admin.models.Permis;
import com.admin.models.PermisTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisRepository extends JpaRepository<Permis, Integer> {
    public Integer deletePermisByIdPermis(int id);
    public PermisTest findPermisTestByIdPermis(int id);
    public Permis findPermisByIdPermis(int id);
}
