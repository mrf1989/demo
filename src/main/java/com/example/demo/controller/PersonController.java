package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/people")
	public String getPeople(ModelMap model) {
		List<PersonDTO> people = this.personService.findAll();
		model.put("people", people);
		
		return "people/list";
	}
	
	@GetMapping(value = "/people/form")
	public String getPersonForm(ModelMap model) {
		Person person = new Person();
		model.put("person", person);
		return "people/form";
	}
	
	@PostMapping(value = "/people/save")
	public String savePerson(PersonDTO person, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "people/form";
		} else {
			this.personService.savePerson(person);
			return "redirect:/people";
		}
	}
	
}
