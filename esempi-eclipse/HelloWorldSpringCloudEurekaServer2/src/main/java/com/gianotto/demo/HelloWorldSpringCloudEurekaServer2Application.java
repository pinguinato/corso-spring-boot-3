package com.gianotto.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HelloWorldSpringCloudEurekaServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringCloudEurekaServer2Application.class, args);
	}

}
