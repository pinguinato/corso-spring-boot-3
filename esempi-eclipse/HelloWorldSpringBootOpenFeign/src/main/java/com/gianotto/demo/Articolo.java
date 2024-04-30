package com.gianotto.demo;

public class Articolo {
	private Integer id;
	private String nome;
	private Integer costo;
	
	public Articolo() {}
	
	public Articolo(Integer id, String nome, Integer costo) {
		this.id = id;
		this.nome = nome;
		this.costo = costo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	
	
}
