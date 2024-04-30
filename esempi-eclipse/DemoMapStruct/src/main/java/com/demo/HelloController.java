package com.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping(value = "/esempio-mapstruct")
	public ResponseEntity<StudenteDTO> esempioMapStruct() {
		
		System.out.println("dentro esempioMapStruct()");
		
		Studente studente = new Studente();
		studente.setNome("Roberto");
		studente.setCognome("Gianotto");
		
		return new ResponseEntity<>(StudenteMapper.mapper.map(studente), HttpStatus.OK);
	}
	
	@PostMapping(value = "/esempio-validazione")
	public ResponseEntity<StudenteDTO> esempioValidazione(@Valid @RequestBody StudenteRequest request) {
		
		System.out.println("dentro esempioValidazione()");
		
		Studente studente = new Studente();
		
		studente.setNome(request.getNome());
		studente.setCognome(request.getCognome());
		
		return new ResponseEntity<>(StudenteMapper.mapper.map(studente), HttpStatus.OK);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
}
