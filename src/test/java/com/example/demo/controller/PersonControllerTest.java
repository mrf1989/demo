package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import com.example.demo.dto.PersonDTO;

@SpringBootTest
class PersonControllerTest {

	@Autowired
	private PersonController personController;
	
	@Test
	void testSavePerson() {
		PersonDTO person = PersonDTO.of(null, "Mario", "Ruano");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		ModelMap model = new ModelMap();
		
		String listView = this.personController.getPeople(model);
		assertEquals("people/list", listView);
		
		String formView = this.personController.getPersonForm(model);
		assertEquals("people/form", formView);
				
		String correctView = this.personController.savePerson(person, result, model);
		assertEquals("redirect:/people", correctView);
		
		ObjectError error = new ObjectError("error", "There is an error");
		result.addError(error);
		String incorrectView = this.personController.savePerson(person, result, model);
		assertEquals("people/form", incorrectView);
	}
	
}
