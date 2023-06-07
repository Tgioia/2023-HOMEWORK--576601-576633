package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String MESSAGGIO_MORSO = "Rrr, ti ho tolto 1 CFU";
	private static final String MESSAGGIO_REGALO = "Mhm, il cibo era buono, ma un morsetto lo do anche a te! CFU-1\nLascio l'attrezzo nella stanza";
	
	public Cane(String nome) {
		super(nome);
		this.presentazione = "\nSe interagisci ti mordo!";
	}
	
	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().addCfu(-1);
		return MESSAGGIO_MORSO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		partita.getGiocatore().addCfu(-1);
		return MESSAGGIO_REGALO;
	}
}