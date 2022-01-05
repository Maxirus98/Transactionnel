package com.p4.permissante.repository;

import com.p4.permissante.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
}
