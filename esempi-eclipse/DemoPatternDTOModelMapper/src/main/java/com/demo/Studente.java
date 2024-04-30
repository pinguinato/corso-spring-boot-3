package com.demo;

public class Studente {
	
	private int matricola;
	private String nome;
	private String cognome;
	
	public Studente() {}
	
	public Studente(int matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public int getMatricola() {
		return this.matricola;
	}
	
	public void setMatricola(int mat) {
		this.matricola = mat;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}
