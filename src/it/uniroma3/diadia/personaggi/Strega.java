package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	private static final String MESSAGGIO_CAMBIO_STANZA_SALUTATA = "è stato bello parlare con te, finisci nella stanza adiacente con più attrezzi";
	private static final String MESSAGGIO_CAMBIO_STANZA_NON_SALUTATA = "maleducato, finisci nella stanza adiacente con meno attrezzi";
	private static final String MESSAGGIO_REGALO = "Mwhahahaha, grazie per questo regalo, lo custodirò con cura";
	protected List<Attrezzo> listaRegalati;	
	
	public Strega(String nome) {
		super(nome);
		this.presentazione = "Vediamo se sai interagire a modo!";
		listaRegalati = new ArrayList<>();
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.haSalutato()) {
			msg = MESSAGGIO_CAMBIO_STANZA_SALUTATA;
			Stanza StaMaxAtt = null;
			for(Stanza s : partita.getLabirinto().getStanzaIniziale().getMapStanzeAdiacenti().values()) {
				if(StaMaxAtt==null) {
					StaMaxAtt = s;
				}
				if(s.getAttrezzi().size()>StaMaxAtt.getAttrezzi().size()) {
					StaMaxAtt = s;
				}
			}
			partita.setStanzaCorrente(StaMaxAtt);
		} else {
			msg = MESSAGGIO_CAMBIO_STANZA_NON_SALUTATA;
			Stanza StaMinAtt = null;
			for(Stanza s : partita.getLabirinto().getStanzaIniziale().getMapStanzeAdiacenti().values()) {
				if(StaMinAtt==null) {
					StaMinAtt = s;
				}
				if(s.getAttrezzi().size()<StaMinAtt.getAttrezzi().size()) {
					StaMinAtt = s;
				}
			}
			partita.setStanzaCorrente(StaMinAtt);
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		listaRegalati.add(attrezzo);
		return MESSAGGIO_REGALO;
	}
}