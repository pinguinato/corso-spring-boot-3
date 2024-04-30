package com.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@Autowired
	private ModelMapper mapper;
	
	
	@GetMapping(value = "/ciao")
	public ResponseEntity<String> ciaoMamma() {
		
		System.out.println("dentro ciaoMamma()");
		
		return new ResponseEntity<>("Ciao mamma", HttpStatus.OK);
	}
	
	@GetMapping(value = "/esempioDTO")
	public ResponseEntity<String> esempioDTO() {
		
		System.out.println("dentro esempioDTO()");
		
		Studente studente = new Studente();
		studente.setMatricola(1111);
		studente.setNome("Roberto");
		studente.setCognome("Gianotto");
		
		return new ResponseEntity<>(convertToDto(studente).toString(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/esempioDTOModelMapper")
	public ResponseEntity<String> esempioDTOModelMapper() {
		
		System.out.println("dentro esempioDTO() com ModelMapper...");
		
		Studente studente = new Studente();
		studente.setMatricola(1111);
		studente.setNome("Roberto");
		studente.setCognome("Gianotto");
		
		return new ResponseEntity<>(convertToDtoWithModelMapper(studente).toString(), HttpStatus.OK);
	}
	
	private StudenteDTO convertToDto(Studente studente) {
		StudenteDTO studenteDto = new StudenteDTO();
		
		studenteDto.setMatricola(studente.getMatricola());
		studenteDto.setNome(studente.getNome());
		studenteDto.setCognome(studente.getCognome());
		
		return studenteDto;
	}
	
	private StudenteDTO convertToDtoWithModelMapper(Studente studente) {
		return mapper.map(studente, StudenteDTO.class);
	}
	
	

}
