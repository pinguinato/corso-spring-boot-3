package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/progetto/actuator")
public class HelloController {
	
public static final Logger logger = LoggerFactory.getLogger(HelloController.class.getName());
	
	@GetMapping(value = "/ciao")
	public ResponseEntity<String> helloWorld() {
		logger.info("Sono dentro helloWorld metodo");
		
		return new ResponseEntity<>("Ciao mamma", HttpStatus.OK);
	}
	

}
