package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class HelloWorldSpringCloudClientController {
	
	@Value("${welcome.message:Ciao se ti rompi}")
	private String welcomeMessage;
	
	@GetMapping("/ciao")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>(welcomeMessage, HttpStatus.OK);
	}
}
