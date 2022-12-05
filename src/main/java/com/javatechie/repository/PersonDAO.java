package com.javatechie.repository;

import com.javatechie.document.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {

    public static final String HASH_KEY = "Persons";
    @Autowired
    private RedisTemplate template;

    public Person addPerson(Person person) {
        template.opsForHash().put(HASH_KEY, person.getId(), person);
        return person;
    }

    public List<Person> getAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Person getPerson(int id) {
        return (Person) template.opsForHash().get(HASH_KEY, id);
    }

    public String deletePerson(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Person removed !!";
    }

    public Person updatePerson(int id, Person person) {
        Person existingPerson = (Person) template.opsForHash().get(HASH_KEY, id);
        if (existingPerson != null) {
            existingPerson.setFirstname(person.getFirstname());
            existingPerson.setLastname(person.getLastname());
            template.opsForHash().put(HASH_KEY, id, existingPerson);
        } else {
            throw new RuntimeException("Person not found");
        }
        return null;
    }
}
