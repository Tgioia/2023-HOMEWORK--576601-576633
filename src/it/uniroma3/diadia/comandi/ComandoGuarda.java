package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IOConsole ioConsole = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		ioConsole.mostraMessaggio("CFU rimasti: " + partita.getCfu());
		ioConsole.mostraMessaggio("Attrezzi in borsa: " + partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome());
	}
	@Override
	public String getNome(){
		return "guarda";
	}
	@Override
	public String getParametro() {
		return "";
	}
	@Override
	public void setParametro(String parametro) {
		
	}
}