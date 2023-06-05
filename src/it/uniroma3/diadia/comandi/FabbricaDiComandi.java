package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public interface FabbricaDiComandi {
	public AbstractComando costruisciComando(String istruzione, IO io, Scanner scanner);
}
