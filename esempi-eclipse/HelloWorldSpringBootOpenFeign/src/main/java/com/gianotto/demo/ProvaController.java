package com.gianotto.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gianotto.gestionale.service.dto.SpesaDTO;

@RestController
public class ProvaController {
	
	private final TestClient testClient;
	
	public ProvaController(TestClient testClient) {
		this.testClient = testClient;
	}
	
	@GetMapping("api/v1/ciao")
	public ResponseEntity<String> getCiaoMamma() {
		return new ResponseEntity<>("Ciao mamma", HttpStatus.OK);
	}
	
	
	@GetMapping("api/v1/testFeign")
	public ResponseEntity<SpesaDTO> getTestFeign() {
		return testClient.testDTO();
	}
	
	@GetMapping("api/v1/articoli")
	public ResponseEntity<Articolo> getArticolo() {
		Articolo articolo = new Articolo();
		articolo.setCosto(10);
		articolo.setId(12);
		articolo.setNome("Coca Cola");
		return new ResponseEntity<>(articolo, HttpStatus.OK);
	}
}
