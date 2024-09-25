package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.services.PersonService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

//    private List<Person> people = new ArrayList<>();

    private PersonService service;

//    Constructor dependency injection
    public PersonController(PersonService service){
        super();
        this.service = service;
    };

    @GetMapping("/person/health")
    public String health() {
        return "Person controller is healthy";
    }

    @GetMapping("/person/getAll")
    public List<PersonDTO> getAll() {
//        delegating responsibility to service - separating concerns
        return this.service.getAllPeople();
    }

    @GetMapping("/person/getById/{id}")
    public PersonDTO getPersonById(@PathVariable int id) {
        return this.service.getPersonWithId(id);
    }
    @GetMapping("/person/getByAge")
    public List<Person> getAllPeopleByAge(@PathParam("age") int age) {
        return this.service.getAllPeopleWithAge(age);
    }

    @GetMapping("/person/getByFirstname")
    public List<Person> getAllPeopleByFirstname(@PathParam("firstname") String firstname) {
        return this.service.getAllPeopleWithFirstname(firstname);
    }

    @GetMapping("/person/getByLastname")
    public List<Person> getAllPeopleByLastname(String lastname) {
        return this.service.getAllPeopleWithLastname(lastname);
    }


    @PostMapping("/person/create")
    public PersonDTO addPerson(@RequestBody @Valid Person person) {
        return this.service.addPerson(person);
    }

    @PutMapping("/person/update")
    public PersonDTO updatePerson(@PathParam("id") int id, @RequestBody @Valid Person person) {
        return this.service.updatePerson(id, person);
    }

//    Passing int id as part of the path
    @DeleteMapping("/person/delete/{id}")
    public boolean deletePerson(@PathVariable int id) {
        return this.service.deletePerson(id);
    }


}
