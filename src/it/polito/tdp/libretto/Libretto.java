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
	
	
	

}
