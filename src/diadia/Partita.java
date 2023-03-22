package diadia;
import ambienti.Labirinto;
import ambienti.Stanza;
import giocatore.Giocatore;

//invio direttamente
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	
	public Partita(){
		labirinto = new Labirinto();
		this.finita = false;
		giocatore = new Giocatore(10);
	}

	public Stanza getStanzaVincente() {
		return labirinto.getFinale();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		labirinto.setCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return labirinto.getCorrente();
	}
	public Giocatore getGiocatore() {
		return giocatore;
	}
	
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== labirinto.getFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.giocatore.getCFU();
	}

	public void setCfu(int cfu) {
		this.giocatore.setCFU(cfu);		
	}	
}
