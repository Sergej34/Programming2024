package Homework_39.citizens.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

//В проекте Citizens, создать имплементацию интерфейса с названием CitizensSetImpl
//основанную на сетах. Над методами, в комментариях, указать их вычислительную сложность.
public class Person implements Comparable<Person> {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Person(int id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge(int age) {
        LocalDate now = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthDate, now);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person person)) return false;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.id, person.id);
    }
}
