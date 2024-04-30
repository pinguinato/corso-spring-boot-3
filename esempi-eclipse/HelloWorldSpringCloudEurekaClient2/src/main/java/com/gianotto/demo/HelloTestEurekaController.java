package com.gianotto.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloTestEurekaController {
	
	@GetMapping("/saluta/{name}")
	public ResponseEntity<String> testEureka1(@PathVariable String name) {
		return new ResponseEntity<>("Ciao, " + name, HttpStatus.OK);
	}
	
	@GetMapping("/saluti")
	public ResponseEntity<String> test1() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
}
