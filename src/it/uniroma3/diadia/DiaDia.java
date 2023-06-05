package it.uniroma3.diadia;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 * (da un'idea di Michael Kolling and David J. Barnes) 
 *       
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio raggiungere al più presto l'uscita. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private Partita partita;
	private IO io;
	
	//costruttore DiaDia
	public DiaDia(Labirinto labirinto, IO io) throws FileNotFoundException, IOException{
		this.partita = new Partita(labirinto);
		this.io = io;
	}
	/**
	 *  Regola l'interazione con l'utente
	 */
	public void gioca(Scanner scanner) {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		istruzione = io.leggiRiga();
		if(istruzione.length()<=0) {
			istruzione = istruzione+"sconosciuto";
		}
		while (!processaIstruzione(istruzione, io, scanner)) {
			istruzione = io.leggiRiga();
			if(istruzione.length()<=0) {
				istruzione = istruzione+"sconosciuto";
			}
		}
	}

	/**
	 * Processa una istruzione 
	 * @param String istruzione
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione,IO io, Scanner scanner) {
		AbstractComando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione, io, scanner);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	//main
	public static void main(String[] args) throws FileNotFoundException, IOException{
//		//atrio
//		.addStanzaIniziale("atrio")
//		//corridoio
//		.addStanza("corridoio")
//		.addAdiacenza("atrio", "corridoio", "est")
//		.addAdiacenza("corridoio", "atrio", "ovest")
//		//n11
//		.addStanza("n11")
//		.addAdiacenza("corridoio", "n11", "est")
//		.addAdiacenza("n11", "corridoio", "ovest")
//		.addMago("mago", "lanterna", 2)
//		//campusone
//		.addStanza("campus")
//		.addAdiacenza("corridoio", "campus", "sud") //unilaterale
//		//bagno
//		.addStanzaMagica("bagno", 0)
//		.addAdiacenza("bagno", "campus", "ovest")
//		.addAdiacenza("campus", "bagno", "est")
//		.addAdiacenza("bagno", "n11", "nord") //unilaterale
//		//n10
//		.addStanza("n10")
//		.addAdiacenza("n10", "corridoio", "sud")
//		.addAdiacenza("corridoio", "n10", "nord")
//		.addCane("cane")
//		//ripostiglio
//		.addStanzaBuia("ripostiglio", "lanterna")
//		.addAdiacenza("ripostiglio", "atrio", "est")
//		.addAdiacenza("atrio", "ripostiglio", "ovest")
//		.addAttrezzo("chiave", 5)
//		//macchinette
//		.addStanzaBloccata("macchinette", "sud", "chiave")
//		.addAdiacenza("macchinette", "atrio", "nord")
//		.addAdiacenza("atrio", "macchinette", "sud")
//		.addAttrezzo("mappa", 1)
//		//mensa
//		.addStanza("mensa")
//		.addAdiacenza("mensa", "macchinette", "nord")
//		.addAdiacenza("macchinette", "mensa", "sud")
//		.addAdiacenza("mensa", "n10", "ovest")
//		.addStrega("strega")
//		//uscita
//		.addStanzaVincente("uscita")
//		.addAdiacenza("mensa", "uscita", "est")
//		.getLabirinto();
		Scanner scanner = new Scanner(System.in);
		IO io = new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("resources/labirinto1", scanner);
		DiaDia diadia = new DiaDia(labirinto, io);
		diadia.gioca(scanner);
		scanner.close();
	}
}