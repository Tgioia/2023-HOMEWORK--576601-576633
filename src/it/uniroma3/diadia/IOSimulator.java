package it.uniroma3.diadia;

import java.util.HashMap;
import java.util.Scanner;

public class IOSimulator implements IO{
	private IOConsole io;
	private HashMap<String, String> mappaComandi;
	
	public IOSimulator(Scanner scanner) {
		this.mappaComandi = new HashMap<>();
		io = new IOConsole();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		io.mostraMessaggio(this.mappaComandi.get(messaggio));
	}

	@Override
	public String leggiRiga(Scanner scanner){
		String messaggio = io.leggiRiga(scanner);
		mappaComandi.put(messaggio, messaggio);
		return messaggio;
	}
}