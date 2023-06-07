package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "interagisci", "saluta", "regala"};
	private IOConsole ioConsole = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<elencoComandi.length; i++) { 
			ioConsole.mostraMessaggio(elencoComandi[i]+" ");
		}
	}
	
	@Override
	public String getNome(){
		return "aiuto";
	}
}