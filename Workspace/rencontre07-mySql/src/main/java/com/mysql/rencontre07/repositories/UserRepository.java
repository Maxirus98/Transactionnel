package com.mysql.rencontre07.repositories;

import com.mysql.rencontre07.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByLoginAndPassword( String input1, String input2);
    public User findById(int id); //existe deja dans JPA
    public User deleteById(int id); //existe deja dans JPA
}
/**
 C.R.U.D
 CREATE = save()
 READ = findBy()
 UPDATE = save()
 DELETE = delete()
 */
