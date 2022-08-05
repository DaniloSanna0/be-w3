package it.epicode.entities.library;

// le entità servono per per collegare "il codice" al database
//le annotazioni come @Inheritance creano la tabella
//@NamedQuery da un nome alla query
//@DiscriminatorColumn discrimina la colonna
//@id si collega alla chiave primaria

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Libreria", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = Elementi.QUERY_SELECT_RICERCA_ISBN, query = "SELECT a FROM Elementi a WHERE a.codiceISBN = :isbn")
@NamedQuery(name = Elementi.QUERY_SELECT_RICERCA_ANNO, query = "SELECT a FROM Elementi a WHERE a.annoPublicazione = :anno")
public abstract class Elementi {
	public static final String QUERY_SELECT_RICERCA_ISBN = "QUERY_SELECT_RICERCA_ISBN";
	public static final String QUERY_SELECT_RICERCA_ANNO = "QUERY_SELECT_RICERCA_ANNO";

	protected String codiceISBN;
	protected String titolo;
	protected String annoPublicazione;
	protected int nPagine;

	public Elementi(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		super();
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPublicazione = annoPublicazione;
		this.nPagine = nPagine;
	}

	public Elementi() {
		super();
	}

	@Id
	public String getCodiceISBN() {
		return codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAnnoPublicazione() {
		return annoPublicazione;
	}

	public int getnPagine() {
		return nPagine;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setAnnoPublicazione(String annoPublicazione) {
		this.annoPublicazione = annoPublicazione;
	}

	public void setnPagine(int nPagine) {
		this.nPagine = nPagine;
	}

}
