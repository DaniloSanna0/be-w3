package it.epicode.entities.prestito;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utente {

	private int id;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private int numeroDiTessera;

	public Utente(String nome, String cognome, LocalDate dataDiNascita, int numeroDiTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTessera = numeroDiTessera;
	}

	public Utente() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public int getNumeroDiTessera() {
		return numeroDiTessera;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public void setNumeroDiTessera(int numeroDiTessera) {
		this.numeroDiTessera = numeroDiTessera;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
