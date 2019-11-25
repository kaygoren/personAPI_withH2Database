package com.tutorial.h2.h2Integration.Repository;

import com.tutorial.h2.h2Integration.Entity.Person;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Integer> {
}
