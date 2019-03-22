package it.polito.tdp.libretto;

import java.util.*;

public class Libretto {
	
	//Lista: interfaccia di java che implemeta metodi per gestire gli elementi della lista.
	//Creo oggetti il più generali possibili.
	
	private List<Voto>voti;  //voti nulla
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
		/*voti è il riferimento alla nostra arrayList, che contiene zero elementi (vuota)*/
	}

	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il (@link Voto) da aggiungere
	 * @return {@code true} nel caso normale, 
	 * 		   {@code false} se non è riuscito ad aggiungere il voto
	 */
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
			voti.add(v);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da ricecare 
	 * @return lista di {@link Voto} aventi quel punteggio (la lista può anche essere vuota)
	 */
	public List<Voto> cercaVoti(int punti){
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti() == punti) {
			//Aggiungo alla nuova lista un oggetto già esistente, non ne faccio una copia, ma ne prendo il riferimento!	
				result.add(v);
			}
		}
		
		return result;
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null}
	 */
	
	
	public Voto cercaEsame(String nomeEsame) {
		//Costruisco un oggetto voto incompleto da usare come criterio di ricerca.
		//usando poi equals(), lui confronta solo il nome del corso!
		Voto voto = new Voto(0, nomeEsame, null);
		int pos = this.voti.indexOf(voto);
		
		if(pos == -1) {
			return null;
		}else
			return this.voti.get(pos);
	}
	
	/***
	 * Dato un {@link Voto}, determina se esiste già un voto con uguale corso e punteggio
	 *
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali, 
	 * 		   {@code false} se non ha trovato il corso, o l'ha trovato con voto diverso
	 */
	
	public boolean esisteGiaVoto(Voto v) {
		
		int pos = this.voti.indexOf(v);
		
		if(pos == -1)
			return false;
		else
			return(v.getPunti() == this.voti.get(pos).getPunti());
	}
	
	/***
	 * Mi dice se il {@link Voto } {@code v} è in conflitto con uno dei voti esistenti, 
	 * se il voto non esiste non c'è conflitto, se esiste e ha punteggio diverso c'è conflitto
	 * @param v
	 * @return {@code true} se il voto esiste ed ha punteggio diverso
	 * 		   {@code false} se il voto non esiste, oppure esiste ma ha lo stesso punteggio
	 */
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos == -1)
			return false;
		else
			return(v.getPunti() != this.voti.get(pos).getPunti());
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti){
			nuovo.add(v.clone());
		}
		
		for(Voto v : nuovo.voti) {
			int punti = v.getPunti();
			if(punti < 24)
				punti = punti + 1;
			else if( punti <= 28)
				punti = punti + 2;
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		List <Voto>cancellare = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti() < 24) {
				cancellare.add(v);
			}
		}
		
		this.voti.removeAll(cancellare);
	}
		

}
