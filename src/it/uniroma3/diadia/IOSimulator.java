package it.uniroma3.diadia;

import java.util.HashMap;

public class IOSimulator implements IO{
	private IOConsole io;
	private HashMap<String, String> mappaComandi;
	
	public IOSimulator() {
		this.mappaComandi = new HashMap<>();
		io = new IOConsole();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		io.mostraMessaggio(this.mappaComandi.get(messaggio));
	}

	@Override
	public String leggiRiga() {
		String messaggio = io.leggiRiga();
		mappaComandi.put(messaggio, messaggio);
		return messaggio;
	}
}