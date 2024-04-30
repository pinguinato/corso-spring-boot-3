package com.gianotto.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoEureka1EnableDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEureka1EnableDiscoveryClientApplication.class, args);
	}

}
