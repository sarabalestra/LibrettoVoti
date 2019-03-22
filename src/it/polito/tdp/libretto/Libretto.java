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
	 * @param v il (@link Voto) da aggiungere
	 */
	public void add(Voto v) {
	/* LA DELEGA:
	 * add() è un metodo della classe Libretto che chiama un metodo che si chiama add() della lista che usa Libretto.
	 * DELEGA al metodo interno l'operazione di aggiunta.
	 * */	
		voti.add(v);
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


}
