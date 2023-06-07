package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	private IOConsole ioConsole = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		ioConsole.mostraMessaggio("Comando non valido");
		ioConsole.mostraMessaggio("Scrivere 'aiuto' per la lista comandi");
	}
	@Override
	public String getNome(){
		return "non valido";
	}
}