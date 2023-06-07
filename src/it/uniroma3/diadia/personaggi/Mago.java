package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private static final String MESSAGGIO_REGALO = "Sei stato gentile, dimezzo il peso dell'attrezzo e te lo lascio qui...";
	private Attrezzo attrezzo;
	
	public Mago(String nome, String nomeAttrezzo, int peso) {
		super(nome);
		this.presentazione = "\nInteragisci e potrei farti un favore!";
		Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
		this.attrezzo = a;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		int nuovoPeso = attrezzo.getPeso()/2;
		attrezzo.setPeso(nuovoPeso);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		return MESSAGGIO_REGALO;
	}
}