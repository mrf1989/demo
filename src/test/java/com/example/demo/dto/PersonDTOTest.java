package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonDTOTest {
	
	@Test
	void testPersonDTOConstructor() {
		PersonDTO person = PersonDTO.of(1, "Mario", "Ruano");
		assertEquals(1, person.getId());
		assertEquals("Mario", person.getFirstName());
		assertEquals("Ruano", person.getLastName());
	}
	
}
