package it.uniroma3.diadia;
import java.io.FileNotFoundException;
import java.io.IOException;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Giocatore giocatore;
	private Labirinto labirinto;
	private boolean finita;

	//costruttore
	public Partita(Labirinto labirinto)throws FileNotFoundException, IOException{
		this.setLabirinto(labirinto);
		this.giocatore = new Giocatore();
		this.finita = false;
	}
	
	public Partita() throws FileNotFoundException, IOException{
		this.giocatore = new Giocatore();
		this.finita = false;
	}

	//getter e setter del giocatore
	public int getCfu() {
		return this.giocatore.getCfu();
	}

	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public void setGiocatore(Giocatore player) {
		this.giocatore = player;
	}
	
	//getter e setter delle stanze
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaIniziale();
	}
	
	//getter e setter labirinto
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return this.finita || this.vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	/**
	 * Restituisce vero se il giocatore ha ancora CFU
	 * @return Boolean
	 */
	public boolean giocatoreIsVivo() {
		if(this.getGiocatore().getCfu()>0) return true;
		return false;
	}	
}
