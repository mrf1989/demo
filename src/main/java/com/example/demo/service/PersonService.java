package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Transactional
	public void savePerson(final PersonDTO person) {
		Person p = new Person();
		p.setFirstName(person.getFirstName());
		p.setLastName(person.getLastName());
		this.personRepository.save(p);
	}
	
	@Transactional(readOnly = true)
	public PersonDTO findPerson(Integer id) {
		Optional<Person> person = this.personRepository.findById(id);
		if (!person.isPresent()) {
			return null;
		} else {
			Person p = person.get();
			return PersonDTO.of(p.getId(), p.getFirstName(), p.getLastName());
		}
	}
	
	@Transactional(readOnly = true)
	public List<PersonDTO> findAll() {
		Iterable<Person> iterablePeople = this.personRepository.findAll();
		List<PersonDTO> people = new ArrayList<>();
		iterablePeople.iterator().forEachRemaining(p -> 
			people.add(PersonDTO.of(p.getId(), p.getFirstName(), p.getLastName()))
		);
		return people;
	}
}
