package com.gianotto.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("HelloWorldSpringCloudEurekaClient2")
public interface HelloInvocationCtrClient {
	@RequestMapping(value = "/api/v1/saluti", method = RequestMethod.GET)
	public ResponseEntity<String> test1();
}
