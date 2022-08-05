package it.epicode;

import java.time.LocalDate;
import java.util.List;

import it.epicode.dao.CatalogoDAO;
import it.epicode.dao.PrestitoDAO;
import it.epicode.entities.library.Elemento;
import it.epicode.entities.library.Libro;
import it.epicode.entities.prestito.Prestito;
import it.epicode.entities.prestito.Utente;

public class Program {
	public static void main(String[] args) {
		Elemento elemento1 = new Libro("9876543210482", "il Libro dei libri", "2022", 126, "Autore1", "Genere1");
		var Service = new CatalogoDAO();
		var Service2 = new PrestitoDAO();
		
		Service.aggiuntaDiUnElementoDelCatalogo(elemento1);
//		Service.rimozioneDiUnElementoDelCatalogoDatoUnCodiceISBN(elemento1.getCodiceISBN());
//		Service.aggiuntaDiUnElementoDelCatalogo(elemento1);
//		Elemento el =Service.ricercaPerISBN(elemento1.getCodiceISBN());
//		System.out.println(el);
//		List<Elemento> lista = Service.ricercaPerAnno("2022");
//		for (Elemento e : lista) {
//			System.out.println(e);
//		}
//		List<Libro> lista2 = Service.ricercaPerAutore("Autore1");
//		for (Libro e : lista2) {
//			System.out.println(e);
//		}
//		System.out.println("RICERCA PER TITOLO ---------------");
//		List<Elemento> lista3 = Service.ricercaPerTitolo("dei");
//		for (Elemento e : lista3) {
//			System.out.println(e);
//		}
		
		Utente utente = new Utente("nome","cognome",LocalDate.of(2022,8,5),3266732);
		Service2.aggiuntaDiUnUtente(utente);
		Prestito prestito = new Prestito(utente,elemento1,LocalDate.now());
		Prestito prestito2 = new Prestito(utente,elemento1,LocalDate.of(1998,5,21));
		Prestito prestito3 = new Prestito(utente,elemento1,LocalDate.of(2011,5,21),LocalDate.of(2011,5,25));
		Service2.aggiuntaDiUnPrestito(prestito);
		Service2.aggiuntaDiUnPrestito(prestito2);
		Service2.aggiuntaDiUnPrestito(prestito3);
		List<Prestito> listaP = Service2.ricercaDeiPrestitiDatoilNTesseraUtente(utente.getNumeroDiTessera());
		for (Prestito p : listaP) {
			System.out.println(p);
		}
		
		List<Prestito> listaP2 = Service2.ricercaPrestitiScadutiENonPagati();
		for (Prestito p : listaP2) {
			System.out.println(p);
		}
	}
}
