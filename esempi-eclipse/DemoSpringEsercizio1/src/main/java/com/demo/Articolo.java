package com.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "articolo")
@Data
@Getter
@Setter
public class Articolo {
	
	@Id
	@Column(name = "codice")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codice;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "prezzo")
	private int prezzo;
}
