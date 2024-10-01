package Homework_39.citizens.dao;

import homework_39.citizens.model.Person;

public interface Citizens {

    boolean add(Person person);

    boolean remove(int id);

    Person find(int id);

    Iterable<Person> find(int minAge, int maxAge);

    Iterable<Person> getAllPersonSortedById();

    Iterable<Person> getAllPersonSortedByAge();

    Iterable<Person> getAllPersonSortedByLastName();

    int size();
}
