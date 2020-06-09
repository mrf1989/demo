package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndexControllerTest {

	@Autowired
	private IndexController indexController;
	
	@Test
	void testGetIndex() {
		String index = this.indexController.getIndex();
		assertEquals("index", index);
	}
	
}
