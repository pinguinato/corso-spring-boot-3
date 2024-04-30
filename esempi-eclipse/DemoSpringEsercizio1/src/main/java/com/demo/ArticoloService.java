package com.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ArticoloService {

	private final ArticoloRepository articoloRepository;
	
	public ArticoloService(ArticoloRepository articoloRepository) {
		this.articoloRepository = articoloRepository;
	}
	
	public List<Articolo> findAllArticles() {
		return articoloRepository.findAll();
	}
	
	
	public void insertArticle(Articolo a) {
		articoloRepository.save(a);
	}
	
	public void updateArticle(Articolo a) {
		articoloRepository.save(a);
	}
	
	public void deleteArticle(Articolo a) {
		articoloRepository.deleteById(a.getCodice());
	}
	
	public Articolo findById(Integer id) throws MyNotFoundException {
		Optional<Articolo> a = articoloRepository.findById(id);
		
		if (a.isEmpty()) throw new MyNotFoundException();
		
		return a.get();
	}
}
