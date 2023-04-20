package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private IOConsole ioConsole = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		ioConsole.mostraMessaggio("Comando non valido");
		ioConsole.mostraMessaggio("Scrivere 'aiuto' per la lista comandi");
		ioConsole.mostraMessaggio("Scrivere 'aiuto <comando>' per le info sul comando");
	}
	@Override
	public String getNome(){
		return "non valido";
	}
	@Override
	public String getParametro() {
		return "";
	}
	@Override
	public void setParametro(String parametro) {
		
	}
}