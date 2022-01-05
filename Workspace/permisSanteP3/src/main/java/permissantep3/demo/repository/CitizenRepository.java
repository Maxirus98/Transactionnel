package permissantep3.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import permissantep3.demo.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
   Citizen findCitizenByCourrielAndPassword(String input1, String input2);
}
