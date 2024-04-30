package com.demo;

import java.util.List;
import java.util.Objects;

import org.apache.el.stream.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.entity.CountryEntity;
import repository.CountryRepository;

@RestController
@RequestMapping("/api")
public class HelloController {

	private final CountryRepository countryRepository;
	
	public HelloController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@GetMapping(value = "/countries")
	public ResponseEntity<List<CountryEntity>> findAllCountries() {
		System.out.println("dentro findAllCountries()");
		return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/country/{name}")
	public ResponseEntity<List<CountryEntity>> findByCountryNameLike(@PathVariable String name) {
		System.out.println("dentro findByCountryNameLike()");
		return new ResponseEntity<>(countryRepository.selByDescrizioneLike(name), HttpStatus.OK);
	}
	
	@GetMapping(value = "/country-name-jpql/{name}")
	public ResponseEntity<List<CountryEntity>> findByCountryNameJPQL(@PathVariable String name) {
		System.out.println("dentro findByCountryNameJPQL()");
		return new ResponseEntity<>(countryRepository.selByDescrizioneLikeJPQL(name), HttpStatus.OK);
	}
	
	@GetMapping(value = "/country-by-id/{id}")
	public ResponseEntity<CountryEntity> findByCountryId(@PathVariable Integer id) {
		System.out.println("dentro findById()");
		
		java.util.Optional<CountryEntity> optional = countryRepository.findById(id);
		
		return new ResponseEntity<>(optional.get(), HttpStatus.OK);
	}
}
