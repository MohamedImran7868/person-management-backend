package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Person;
import com.example.repositories.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService {

    private final   PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        log.info("Creating person with name={}", person.getName());
        return  personRepository.save(person);
    }
    
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(String id) {
        if (!personRepository.existsById(id)) {
            log.warn("Deleting person with id={}", id);
            throw new IllegalArgumentException("Person with ID " + id + " not found");
        }
        log.info("Deleting person with id={}", id);
        personRepository.deleteById(id);
    }

    public List<Person> findPersonsByName(String name) {
        log.info("Searching persons with name containing '{}'", name);
        return personRepository.findByNameContainingIgnoreCase(name);
    }

    public Person updatePerson (String id, Person updatedPerson) {
        log.info ("Updating person with id={}", id);
        return personRepository.findById(id).map(person -> {
            person.nameSetter(updatedPerson.getName());
            person.ageSetter(updatedPerson.getAge());
            return personRepository.save(person);
        }).orElseThrow(() -> {
            log.warn("Person with id={} not found for update", id);
            return new IllegalArgumentException("Person with ID " + id + " not found");
        });
    }
}
