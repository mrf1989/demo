package com.example.demo.dto;

import lombok.Data;

@Data(staticConstructor = "of")
public class PersonDTO {

	private final Integer id;
	private final String firstName;
	private final String lastName;
	
}
