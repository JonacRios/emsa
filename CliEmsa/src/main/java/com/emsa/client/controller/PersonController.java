package com.emsa.client.controller;

import com.emsa.client.dto.PersonDTO;
import com.emsa.client.model.Person;
import com.emsa.client.service.impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonServiceImpl personService;

    @GetMapping("/")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable String id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/create")
    public String createPerson(@RequestBody PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setNombre(personDTO.getNombre());
        person.setEmail(personDTO.getEmail());
        person.setTelefono(personDTO.getTelefono());

        personService.createPerson(person);
        return "Person has been created successfully";
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }
}
