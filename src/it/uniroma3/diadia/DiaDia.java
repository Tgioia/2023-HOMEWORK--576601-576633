package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 *Questa e' la classe principale crea e istanzia tutte le altre
 *
 *@author  docente di POO 
 *       (da un'idea di Michael Kolling and David J. Barnes) 
 *       
 *  @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	private IOConsole ioConsole;
	private Partita partita;
	//costruttore DiaDia
	public DiaDia() {
		this.ioConsole = new IOConsole();
		this.partita = new Partita();
	}
	/**
	 *  Regola l'interazione con l'utente
	 */
	public void gioca() {
		String istruzione;
		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		istruzione = ioConsole.leggiRiga();
		if(istruzione.length()<=0) {
			istruzione=istruzione+"sconosciuto";
		}
		while (!processaIstruzione(istruzione)) {
			istruzione = ioConsole.leggiRiga();
			if(istruzione.length()<=0) {
				istruzione=istruzione+"sconosciuto";
			}
		}
	}   

	/**
	 * Processa una istruzione 
	 * @param String istruzione
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		} else if(comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("posa")){
			this.posa(comandoDaEseguire.getParametro());
		} else {
			ioConsole.mostraMessaggio("Comando sconosciuto");
		}
		if (this.partita.vinta()) {
			ioConsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   
/**
 * Prende un attrezzo dalla stanza corrente e lo mette nella borsa
 * 
 * @param nomeAttrezzo
 * @return nulla
 */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null)
			ioConsole.mostraMessaggio("Che attrezzo vuoi prendere?");
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(partita.getGiocatore().prendiAttrezzo(attrezzo)) {
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				ioConsole.mostraMessaggio("Attrezzo preso");
			} else
				ioConsole.mostraMessaggio("spazio non sufficiente");
		} else {
			ioConsole.mostraMessaggio("Attrezzo non trovato");
		}
	}
	/**
	 * Prende un attrezzo dalla borsa del giocatore e lo posa nella stanza corrente
	 * @param nomeAttrezzo
	 * @return nulla
	 */
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null)
			ioConsole.mostraMessaggio("Che attrezzo vuoi lasciare?");
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().lasciaAttrezzo(attrezzo);
			ioConsole.mostraMessaggio("Attrezzo posato");
		} else {
			ioConsole.mostraMessaggio("Attrezzo non posseduto");
		}
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			ioConsole.mostraMessaggio(elencoComandi[i]+" ");
		ioConsole.mostraMessaggio("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			ioConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		}
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");;  // si desidera smettere
	}
	//main
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}