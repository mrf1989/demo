package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public void savePerson(final PersonDTO person) {
		Person p = new Person();
		p.setFirstName(person.getFirstName());
		p.setLastName(person.getLastName());
		this.personRepository.save(p);
	}
	
	public Person findPerson(Integer id) {
		Optional<Person> person = this.personRepository.findById(id);
		if (!person.isPresent()) {
			return null;
		} else {
			return person.get();
		}
	}
	
	public Iterable<Person> findAll() {
		return this.personRepository.findAll();
	}
}
