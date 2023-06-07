package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando{
	private IO io; 
	private String nomeAttrezzo;
	private String messaggio;

	@Override
	public void esegui(Partita partita) {
		io = new IOConsole();
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(this.nomeAttrezzo!=null) {
			if(personaggio!=null) {
				if(partita.getGiocatore().getBorsa().hasAttrezzi()) {
					if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
						this.messaggio = personaggio.riceviRegalo(partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo), partita);
						partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
						io.mostraMessaggio(messaggio);
					} else {
						io.mostraMessaggio("Non hai nessun oggetto chiamato: " + nomeAttrezzo);
					}
				} else {
					io.mostraMessaggio("Non hai attrezzi da regalare...");
				}
			} else { 
				io.mostraMessaggio("Non c'è nessuno a cui regalare qualcosa...");
			} 
		} else {
			io.mostraMessaggio("Devi dirmi cosa vuoi regalare!");
		}
	}
	@Override
	public String getNome() {
		return "regala";
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
