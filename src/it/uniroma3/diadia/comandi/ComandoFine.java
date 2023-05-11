package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */
public class ComandoFine implements Comando {
	private IOConsole ioConsole = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");;  // si desidera smettere
	}
	@Override
	public String getNome(){
		return "fine";
	}
	@Override
	public String getParametro() {
		return "";
	}
	@Override
	public void setParametro(String parametro) {
		
	}
}