package com.example.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Person;

public interface PersonRepository extends MongoRepository<Person, String>{
    void deleteById(String id);
    List<Person> findByNameContainingIgnoreCase(String name);
}


