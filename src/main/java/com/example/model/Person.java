package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "persons")
public class Person {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    public String getId() {
        return id;
    }

    public  void nameSetter(String name) {
        this.name = name; 
    }

    public String getName() {
        return name;
    }

    public  void ageSetter(Integer age) {
        this.age = age; 
    }

    public int getAge() {
        return age;
    }
}
