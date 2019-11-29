package com.tutorial.h2.h2Integration.Controller;

import com.tutorial.h2.h2Integration.Entity.Person;
import com.tutorial.h2.h2Integration.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/test")
    public ResponseEntity test(){
        return ResponseEntity.status(HttpStatus.OK)
                .header("hataVarMi", "false")
                .eTag("tag")
                .contentType(MediaType.APPLICATION_JSON)
                .body("Here is the test body!");
    }

    @GetMapping("/testT")
    public String testT(){
        return "Here is the body without ResponseEntity!";
    }

    @PostMapping("/welcome")
    public void welcome(RequestEntity<Person> person){
        System.out.println("url     ->" + person.getUrl());
        System.out.println("headers ->" + person.getHeaders());
        System.out.println("body    ->" +  person.getBody());
        System.out.println("name, age ->" + person.getBody().getName() + " " + person.getBody().getAge());
    }

}
