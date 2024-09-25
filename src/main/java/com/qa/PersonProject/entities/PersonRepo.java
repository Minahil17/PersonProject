package com.qa.PersonProject.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository< Person, Integer> {

    List<Person> findPersonByAge(int age);

    List<Person> findPersonByFirstname(String firstname);

    @Query(value = "SELECT * from Person WHERE lastname = ?1", nativeQuery = true)
    List<Person> findPersonByLastname(String lastname);

//    Person findPersonById(int id);
}
