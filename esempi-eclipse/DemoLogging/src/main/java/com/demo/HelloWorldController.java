package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
	
	public static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class.getName());
	
	@GetMapping(value = "/ciao")
	public ResponseEntity<String> helloWorld() {
		System.out.println("dentro il controller heeloWorld()");
		logger.info("Sono dentro helloWorld metodo");
		
		return new ResponseEntity<String>("ciao mamma", HttpStatus.OK);
	}

}
