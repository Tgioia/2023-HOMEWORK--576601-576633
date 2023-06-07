package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Prende un attrezzo dalla stanza corrente e lo mette nella borsa
 * 
 * @param nomeAttrezzo
 * @return nulla
 */
public class ComandoPrendi extends AbstractComando {
	
	private String nomeAttrezzo;
	private IOConsole ioConsole = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
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
	
	@Override
	public String getNome() {
		return "prendi";
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