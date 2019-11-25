package com.tutorial.h2.h2Integration.Controller;

import com.tutorial.h2.h2Integration.Entity.Person;
import com.tutorial.h2.h2Integration.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping
    private List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    private Person getPerson(@PathVariable("id") int id){
        return personService.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    private void deletePerson(@PathVariable("id") int id){
        personService.delete(id);
    }

    @PostMapping
    private int savePerson(@RequestBody Person person){
        personService.saveOrUpdate(person);
        return person.getId();
    }

}
