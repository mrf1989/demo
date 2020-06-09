package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.PersonDTO;

@SpringBootTest
class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	@Test
	void testSavePerson() {
		PersonDTO person = PersonDTO.of(1, "Mario", "Ruano");
		this.personService.savePerson(person);
		assertEquals("Mario", this.personService.findPerson(1).getFirstName());
	}
	
	@Test
	void testFindNullPerson() {
		PersonDTO person = this.personService.findPerson(10);
		assertNull(person);
	}
	
	@Test
	void testFindAllPeople() {
		List<PersonDTO> people = this.personService.findAll();
		assertNotNull(people);
	}
	
}
