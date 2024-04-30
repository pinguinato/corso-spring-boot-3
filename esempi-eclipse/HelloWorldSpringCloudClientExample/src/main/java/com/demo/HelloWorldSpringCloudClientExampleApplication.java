package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class HelloWorldSpringCloudClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringCloudClientExampleApplication.class, args);
	}

}
