package it.epicode.entities.library;

import javax.persistence.Entity;

@Entity
public class Libri extends Elementi {

	private String autore;
	private String genere;

	public Libri(String codiceISBN, String titolo, String annoPublicazione, int nPagine, String autore, String genere) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public Libri(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
	}

	public Libri() {

	}

	public Libri(String autore, String genere) {
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

	public static Libri fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");

		return new Libri(split[1], split[2], split[3], Integer.valueOf(split[4]), split[5], split[6]);
	}

}
