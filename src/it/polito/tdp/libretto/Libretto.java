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
	
	

}
