package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha la responsabilità di gestire i CFU del giocatore e
 * di memorizzare gli attrezzi in un oggetto istanza della classe borsa
 *
 * @author  Crozzoli, Gioia
 * @see Partita
 * @version base
 */

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private Borsa borsa;
	private int cfu;
	//costruttori
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		borsa = new Borsa();
	}
	public Giocatore(int pesoMax) {
		cfu = 20;
		borsa = new Borsa(pesoMax);
	}
	//getter e setter 
	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	public void addCfu(int cfu) {
		this.cfu += cfu;		
	}
	//metodi
	public boolean prendiAttrezzo(Attrezzo attrezzo){
		return borsa.addAttrezzo(attrezzo);
	}
	public Attrezzo lasciaAttrezzo(Attrezzo attrezzo){
		return borsa.removeAttrezzo(attrezzo.getNome());
	}
}