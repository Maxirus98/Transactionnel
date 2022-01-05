package ca.qc.cal.rencontre01;

import ca.qc.cal.rencontre01.ca.qc.cal.rencontre01.models.Employee;
import ca.qc.cal.rencontre01.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
//Spring Bean
@Component
public class DatabaseRunner implements CommandLineRunner {
    //IOC = Injection de données
    //Srping factory annotation --> Inject toutes les méthodes de EmployeeRepository
    @Autowired
    private EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        loadBd();
    }

    private void loadBd(){
        Employee emp1 = new Employee();
        emp1.setNom("Geek1");
        emp1.setAge(22);
        emp1.setSalaire("200000");
        emp1.setPoste("TI");
        emp1.setVille("MTL");

        Employee emp2 = new Employee();
        emp2.setNom("Geek2");
        emp2.setAge(23);
        emp2.setSalaire("100000");
        emp2.setPoste("TI2");
        emp2.setVille("QC");

        List<Employee> employees = Arrays.asList(emp1, emp2);
        //Car JpaRepository fonctionne avec des LIST, car les valeurs des listes peuvent être dupliqués.
        this.repository.saveAll(employees);
    }

    private void emptyBD(){
        //Seulement possible a cause de @Autowired qui Inject les méthodes de EmployeeRepository qui extends JpaRepository
        this.repository.deleteAll();
    }
}
