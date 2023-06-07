package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Prende un attrezzo dalla borsa del giocatore e lo posa nella stanza corrente
 * @param nomeAttrezzo
 * @return nulla
 */
public class ComandoPosa extends AbstractComando{
	private IOConsole ioConsole = new IOConsole();
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
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

	@Override
	public String getNome(){
		return "posa";
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override 
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
