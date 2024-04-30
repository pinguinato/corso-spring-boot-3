package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloctr")
public class HelloCtr {
	
	@Value("${mia.properties.nome:nome}")
	private String myName;
	
	@Value("${mia.properties.cognome:cognome}")
	private String mySurname;
	
	@GetMapping("/mie-properties")
	public String myProperties() {
		System.out.println("dentro mie properties");
		
		return "Il tuo nome completo è " + myName + " " + mySurname;
	}
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("dentro modificato 2");
		
		return "Salve mondo crudele!";
	}
}
