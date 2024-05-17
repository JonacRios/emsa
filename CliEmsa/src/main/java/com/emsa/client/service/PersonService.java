package com.emsa.client.service;

import com.emsa.client.model.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPersons();
    public Person getPersonById(String id);
    Person createPerson(Person person);
    Person updatePerson(String id, Person person);
    void deletePerson(String id);
}