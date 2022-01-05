package ca.qc.cal.rencontre01.repository;

import ca.qc.cal.rencontre01.ca.qc.cal.rencontre01.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  /* //Méthodes abstraites/Signature de méthodes
    public void toto();
    abstract void tata();

    public static final String _CONSTANTE = "Geek1";

    public static void main(String[] args) {
        System.out.println(_CONSTANTE);
    }*/
}
