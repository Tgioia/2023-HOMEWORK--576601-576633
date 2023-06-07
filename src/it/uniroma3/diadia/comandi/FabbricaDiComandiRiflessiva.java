package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	Scanner scannerDiParole;
	
	@Override
	public AbstractComando costruisciComando(String istruzione, IO io) {
		int x = 0;
		String nomeComando = istruzione;
		String parametro = null;
		if(istruzione.indexOf(" ")>0) {
			x = istruzione.indexOf(" ");
			nomeComando = istruzione.substring(0, x);
			parametro = istruzione.substring(x+1);
		}			
		AbstractComando comando = null;
		try {
			String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
			nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
			nomeClasse += nomeComando.substring(1);
			comando = (AbstractComando)Class.forName(nomeClasse).getDeclaredConstructor().newInstance();
			comando.setParametro(parametro);
		} catch (Exception e) {
			comando = new ComandoNonValido();
			io.mostraMessaggio("Comando inesistente");
		}
		return comando;
	}
}