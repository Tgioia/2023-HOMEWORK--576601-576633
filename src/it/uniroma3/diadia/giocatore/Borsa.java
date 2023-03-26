package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe serve a salvare gli attrezzi del giocatore 
 *
 * @author  Crozzoli, Gioia
 * @see Partita
 * @version base
 */
public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	//costruttori
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	/**aggiunge un attrezzo
	 * 
	 * @param attrezzo
	 * @return true se aggiunto, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	/**
	 * 
	 * @param nomeAttrezzo
	 * @return attrezzo eliminato
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for(int i=0; i<numeroAttrezzi; i++) {
			if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
				for(int j=i; j<numeroAttrezzi; j++) {
					attrezzi[j]=attrezzi[j+1];
				}
				a = attrezzi[i];
				attrezzi[numeroAttrezzi]=null;
				numeroAttrezzi--;
			}
		}
		return a;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	/**Restituisce il riferimento dando il nome dell'attrezzo 
	 * 
	 * @param nomeAttrezzo
	 * @return riferimento all'attrezzo 
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	/**Conta il peso totale degli attrezzi
	 * @return  int peso	
	 */
	}public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	/**
	 * ritorna true se la borsa è vuota
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	/**
	 * ritorna true se possiede l'attrezzo richiesto
	 * @param nomeAttrezzo
	 * @return boolean
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}