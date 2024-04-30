package com.demo;

public class StudenteDTO {
	private int matricola;
	private String nome;
	private String cognome;
	
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Override
	public String toString() {
		return "Matricola: " + this.matricola + ", Nome: " + this.nome + ", Cognome: " + this.cognome;
	}
	
	
}
