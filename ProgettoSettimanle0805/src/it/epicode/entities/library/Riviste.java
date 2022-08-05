package it.epicode.entities.library;

import javax.persistence.Entity;

@Entity
public class Riviste extends Elemento {

	Periodicità periodicità;

	public Riviste(String codiceISBN, String titolo, String annoPublicazione, int nPagine, Periodicità periodicità) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
		this.periodicità = periodicità;
	}

	public Riviste() {
		super();
	}

	public Riviste(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
	}

	public Riviste(Periodicità periodicità) {
		this();
		this.periodicità = periodicità;
	}

	public Periodicità getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Periodicità periodicità) {
		this.periodicità = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista [periodicità=" + periodicità + ", codiceISBN=" + codiceISBN + ", titolo=" + titolo
				+ ", annoPublicazione=" + annoPublicazione + ", nPagine=" + nPagine + "]@";
	}

	public static Riviste fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");
		Periodicità periodicita = Periodicità.valueOf(split[5]);

		return new Riviste(split[1], split[2], split[3], Integer.valueOf(split[4]), periodicita);
	}

}
