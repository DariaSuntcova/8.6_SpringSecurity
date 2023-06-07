package ru.netology.springsecurity.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springsecurity.entity.Person;
import ru.netology.springsecurity.service.Service;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @Secured("{ROLE_READ}")
    @GetMapping("/persons/by-city")
    public List<Person> getPersons(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @RolesAllowed("{ROLE_WRITE}")
    @GetMapping("/persons/by-age")
    public List<Person> getAge(@RequestParam("age") int age) {
        return service.getAge(age);
    }

    @PreAuthorize("hasAnyRole('WRITE') or hasAnyRole('DELETE')")
    @GetMapping("/persons/by-fullname")
    public Optional<Person> getNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getNameSurname(name, surname);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/persons/all")
    public List<Person> getAllNamePersons() {
        return service.getAllNamePersons();
    }

}
