package com.admin2.repository;

import com.admin2.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
   Citizen findCitizenByCourrielAndPassword(String input1, String input2);
}
