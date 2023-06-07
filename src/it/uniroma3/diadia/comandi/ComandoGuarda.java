package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	private IOConsole ioConsole = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		ioConsole.mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().getDescrizione());
		ioConsole.mostraMessaggio("CFU rimasti: " + partita.getCfu());
		ioConsole.mostraMessaggio("Attrezzi in borsa: " + partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome());
	}
	@Override
	public String getNome(){
		return "guarda";
	}
}