package com.demo;

import jakarta.validation.constraints.NotBlank;

public class StudenteRequest {
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@NotBlank(message = "Il nome è obbligatorio")
	private String nome;
	
	@NotBlank(message = "Il cognome è obbligatorio")
	private String cognome;

}
