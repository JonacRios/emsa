package com.emsa.client.service.impl;

import com.emsa.client.model.Person;
import com.emsa.client.repository.IPersonRepository;
import com.emsa.client.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final IPersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(String id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(String id, Person person) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            return personRepository.save(person);
        }
        return null;
    }

    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }
}