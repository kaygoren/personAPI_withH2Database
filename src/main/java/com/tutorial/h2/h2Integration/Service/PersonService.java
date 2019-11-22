package com.tutorial.h2.h2Integration.Service;

import com.tutorial.h2.h2Integration.Entity.Person;
import com.tutorial.h2.h2Integration.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons(){
        List<Person> personList = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> personList.add(person));
        return personList;
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).get();
    }

    public void saveOrUpdate(Person person){
        personRepository.save(person);
    }

    public void delete(int id){
        personRepository.deleteById(id);
    }
}
