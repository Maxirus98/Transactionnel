package models;

import java.util.Comparator;

public class User  implements Comparable<User>, Comparator<User> {
    private Integer id;
    private String name;
    private Float salary;

    public User(){
    }

    public User(Integer id, String name, Float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


    @Override
    public int compareTo(User u) {
        return this.getId().compareTo(u.getId());
    }

    @Override
    public int compare(User o1, User o2) {
        return 0;
    }
}
