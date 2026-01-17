package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CorsConfig;
import com.example.model.Person;
import com.example.service.PersonService;

import jakarta.validation.Valid;

// This handle the http req and returns the data
@RestController
public class PersonController {

    @SuppressWarnings("unused")
	private final CorsConfig corsConfig;
	private final PersonService personService;

	public PersonController(PersonService personService, CorsConfig corsConfig) {
		this.personService = personService;
		this.corsConfig = corsConfig;
	}

    // when get req send to /person, run this method
	@PostMapping("/person")
	public Person addPerson(@Valid @RequestBody Person person) {
		return personService.createPerson(person);
	}

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable String id) {
		personService.deletePerson(id);
	}

	@GetMapping("/persons/search")
	public List<Person> findPersonsByName(@RequestParam(value = "name", defaultValue = "") String name) {
		return personService.findPersonsByName(name);
	}

	@PutMapping("/person/update/{id}")
	public Person updatePerson(@PathVariable String id, @Valid @RequestBody Person person) {
		return personService.updatePerson(id, person);
	}
    
}