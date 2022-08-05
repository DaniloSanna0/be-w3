package it.epicode.entities.library;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Libro.QUERY_SELECT_RICERCA_AUTORE, query = "SELECT a FROM Libro a WHERE a.autore = :autore")
public class Libro extends Elemento {

	public static final String QUERY_SELECT_RICERCA_AUTORE = "QUERY_SELECT_RICERCA_AUTORE";
	
	private String autore;
	private String genere;

	public Libro(String codiceISBN, String titolo, String annoPublicazione, int nPagine, String autore, String genere) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public Libro(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
	}

	public Libro() {

	}

	public Libro(String autore, String genere) {
		this();
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", codiceISBN=" + codiceISBN + ", titolo=" + titolo
				+ ", annoPublicazione=" + annoPublicazione + ", nPagine=" + nPagine + "]@";
	}

	public static Libro fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");

		return new Libro(split[1], split[2], split[3], Integer.valueOf(split[4]), split[5], split[6]);
	}

}
