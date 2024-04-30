package com.gianotto.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gianotto.gestionale.service.dto.SpesaDTO;

@FeignClient(name = "GestioneSpeseDiCasa", url = "localhost:9000")
public interface TestClient {
		
	
	@RequestMapping(value = "/api/v1/test2", method = RequestMethod.GET)
	public ResponseEntity<SpesaDTO> testDTO();
}
