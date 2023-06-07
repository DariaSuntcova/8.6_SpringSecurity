package ru.netology.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.springsecurity.entity.Person;
import ru.netology.springsecurity.entity.PersonPK;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PersonRepository extends JpaRepository<Person, PersonPK> {

    @Query("select p from Person p where lower(p.cityOfLiving) = lower(:city)")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("select p from Person p where p.age < :age")
    List<Person> findByAgeLessThanOrderByAge(@Param("age") int age);

    @Query("select p from Person p where lower(p.name) = lower(:name) and lower(p.surname) = lower(:surname)")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("SELECT name FROM Person")
    List<Person> getAllNamePersons();


}
