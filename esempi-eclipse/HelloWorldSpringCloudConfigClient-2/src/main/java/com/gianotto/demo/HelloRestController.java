package com.gianotto.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@Value("${msg:Config Server is not working. Please check...}")
	private String msg;
	
	
	@GetMapping("/msg")
	public String getMsg(){
		return this.msg;
	}

}
