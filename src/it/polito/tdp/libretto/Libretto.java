package it.polito.tdp.libretto;

import java.util.*;

public class Libretto {
	
	//Lista: interfaccia di java che implemeta metodi per gestire gli elementi della lista.
	//Creo oggetti il pi� generali possibili.
	
	private List<Voto>voti;  //voti nulla
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
		/*voti � il riferimento alla nostra arrayList, che contiene zero elementi (vuota)*/
	}

	/**
	 * Aggiunge un nuovo voto al libretto
	 * @param v il (@link Voto) da aggiungere
	 */
	public void add(Voto v) {
	/* LA DELEGA:
	 * add() � un metodo della classe Libretto che chiama un metodo che si chiama add() della lista che usa Libretto.
	 * DELEGA al metodo interno l'operazione di aggiunta.
	 * */	
		voti.add(v);
	}
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da ricecare 
	 * @return lista di {@link Voto} aventi quel punteggio (la lista pu� anche essere vuota)
	 */
	public List<Voto> cercaVoti(int punti){
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti() == punti) {
			//Aggiungo alla nuova lista un oggetto gi� esistente, non ne faccio una copia, ma ne prendo il riferimento!	
				result.add(v);
			}
		}
		
		return result;
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui � specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null}
	 */
	
	
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v : this.voti) {
	/*RICORDA: == confronta le posizioni in memoria, per confrontare le stringhe si usa equals()
	 *          posso usare == per confrontare variabili semplici (NON GLI OGGETTI) quindi con gli interi, char o null
	 *compareTo() confronta due oggetti e dice quale viene prima e quale dopo, ci sono oggetti in cuui non ha senso mettere un ordine*/
			
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}
	
	/***
	 * Dato un {@link Voto}, determina se esiste gi� un voto con uguale corso e punteggio
	 *
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali, 
	 * 		   {@code false} se non ha trovato il corso, o l'ha trovato con voto diverso
	 */
	
	public boolean esisteGiaVoto(Voto v) {
		Voto trovato = this.cercaEsame(v.getCorso());
		
		if(trovato == null)
			return false;
		if(trovato.getPunti() == v.getPunti()) {
			return true;
		} else {
			return false;
		}
		
	}


}
