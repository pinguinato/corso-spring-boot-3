package com.demo;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articolo")
public class ArticoloController {
	
	private final ArticoloService articoloService;
	
	public ArticoloController(ArticoloService articoloService) {
		this.articoloService = articoloService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Articolo>> findAllArticles() {
		System.out.println("dentro findAllArticles()");
		return new ResponseEntity<>(articoloService.findAllArticles(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Articolo> findAnArticle(@PathVariable Integer id) throws MyNotFoundException {
		System.out.println("dentro findAllArticles()");
		
		return new ResponseEntity<>(articoloService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<String> insertArticle(@RequestBody Articolo a) {
		System.out.println("dentro insertArticle()");
		articoloService.insertArticle(a);
		return new ResponseEntity<>("Inserimento articolo effettuato", HttpStatus.CREATED); 
		
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateArticle(@RequestBody Articolo a) {
		System.out.println("dentro updateArticle()");
		articoloService.updateArticle(a);
		return new ResponseEntity<>("Aggiornamento articolo effettuato", HttpStatus.OK); 
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteArticle(@RequestBody Articolo a) {
		System.out.println("dentro deleteArticle()");
		articoloService.deleteArticle(a);
		return new ResponseEntity<>("Cancellazione articolo effettuata", HttpStatus.OK); 
	}
}
