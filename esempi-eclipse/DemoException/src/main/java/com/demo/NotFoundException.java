package com.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;
	private String messaggio = "Risorsa non trovata";
	
	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String messaggio) {
		super(messaggio);
		this.messaggio = messaggio;
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	public void setMessaggio(String m) {
		this.messaggio = m;
	}
}
