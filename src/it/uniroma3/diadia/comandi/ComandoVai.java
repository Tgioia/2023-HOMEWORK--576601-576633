package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */
public class ComandoVai extends AbstractComando{
	private String direzione;
	private IOConsole ioConsole = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		//prendiamo la stanza corrente
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		//prendiamo la prossima stanza
		Stanza prossimaStanza = null;
		//se non ben dichiarato
		if(direzione==null || !isDirezione(this.direzione)) {
			ioConsole.mostraMessaggio("Dove vuoi andare? "
					+ "Devi specificare una direzione");
			return;
		}
		//assegno prossima stanza
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		//verifico che ci sia una stanza in questa direzione
		if(prossimaStanza == null) {
			ioConsole.mostraMessaggio("Nessuna stanza in questa direzione");
			return;
		}
		//
		partita.setStanzaCorrente(prossimaStanza);
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	public boolean isDirezione(String dir) {
		try {
			Direzioni.valueOf(dir);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		} 
	}

		@Override
		public String getNome(){
			return "vai";
		}

		@Override
		public void setParametro(String parametro) {
			this.direzione = parametro;
		}

		@Override 
		public String getParametro() {
			return this.direzione;
		}
	}