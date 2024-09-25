package com.qa.PersonProject.services;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.entities.PersonRepo;
import com.qa.PersonProject.exceptions.PersonWithIdNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PersonService {

    private PersonRepo repo;

    private ModelMapper mapper;

    public PersonService(PersonRepo repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

//    private List<Person> people = new ArrayList<>();

    private PersonDTO mapToDTO(Person person) {
//        mapper does comparison between person and personDTO
//        .class gives datatype of class
        return this.mapper.map(person, PersonDTO.class);
    }

    public PersonDTO addPerson(Person person) {
//         this.people.add(person);
//         return this.people.get(this.people.size() -1 );

//        Any Additional LOGIC can go here ----------------

        Person saved = this.repo.save(person);
        return this.mapToDTO(saved);
    }

    public List<PersonDTO> getAllPeople() {
//        return this.repo.findAll();
//        We want to grab and iterate collection of ppl and then map them to DTOs and return a list of DTOs
//        .stream() - turns collection into stream
//        .map(tell it which function to perform) - want to perform function on each item in collection
//        now have a stream of person DTOs - need to collect and return as a list
//        .collect(Collectors.toList())
        return this.repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<Person> getAllPeopleWithAge(int age) {
        return this.repo.findPersonByAge(age);
    }

    public List<Person> getAllPeopleWithFirstname(String firstname) {
        return this.repo.findPersonByFirstname(firstname);
    }

    public List<Person> getAllPeopleWithLastname(String lastname) {
        return this.repo.findPersonByLastname(lastname);

    }

    public PersonDTO getPersonWithId(int id) {
        Person found = this.repo.findById(id).orElseThrow(PersonWithIdNotFound::new);
        return this.mapToDTO(found);
    }

    //    Find byID returns an optional - need a method to get person out of optional
    public PersonDTO updatePerson(int id,Person person) {
//        this.people.remove(id);
//        this.people.add(id, person);
//        return this.people.get(id);
        Optional<Person> existingPerson = this.repo.findById(id);
        Person existing = existingPerson.get();
//        Mapping all parameters that could be updated
        existing.setAge(person.getAge());
        existing.setFirstname(person.getFirstname());
        existing.setLastname(person.getLastname());
//        We changed return type to PersonDTO so need to change return to map it to that:
        Person updated = this.repo.save(existing);
        return this.mapToDTO(updated);
    }

    public boolean deletePerson(int id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }



}
