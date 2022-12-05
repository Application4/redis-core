package com.javatechie;

import com.javatechie.document.Person;
import com.javatechie.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/person")
public class RedisPocApplication {

	@Autowired
	private PersonDAO dao;

	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		return dao.addPerson(person);
	}

	@GetMapping
	public List<Person> getAll() {
		return dao.getAll();
	}

	@GetMapping("/{id}")
	public Person getPerson(@PathVariable int id) {
		return dao.getPerson(id);
	}

	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		return dao.deletePerson(id);
	}

	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
		return dao.updatePerson(id, person);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisPocApplication.class, args);
	}

}
