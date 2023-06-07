package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{
	IO io; 

	@Override
	public void esegui(Partita partita) {
		io = new IOConsole();
		if(partita.getStanzaCorrente().getPersonaggio()!=null) {
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		} else {
			io.mostraMessaggio("non c'è nessuno da salutare");
		}
	}

	@Override
	public String getNome() {
		return "saluta";
	}
}