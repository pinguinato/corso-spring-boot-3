package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping(value = "/ciao")
	public ResponseEntity<String> helloWorld() throws DuplicateException {
		System.out.println("dentro il controller heeloWorld()");
		
		if (1 == 1) {
			throw new DuplicateException("Errore DuplicateException");
		}
		
		return new ResponseEntity<String>("ciao mamma", HttpStatus.OK);
		
	}
	
}
