package com.gianotto.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/invocator")
public class HelloInvocationController {
	
	private final HelloInvocationCtrClient helloInvocationCtrClient;
	
	public HelloInvocationController(HelloInvocationCtrClient helloInvocationCtrClient) {
		this.helloInvocationCtrClient = helloInvocationCtrClient;
	}
	
	// verrà invocato l'api /api/v2/invocator/test --> /api/v1/saluti
	@GetMapping("/test")
	public ResponseEntity<String> test1() {
		return helloInvocationCtrClient.test1();
	}

}
