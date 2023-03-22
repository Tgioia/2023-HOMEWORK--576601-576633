package ambienti;
import attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	private Stanza stanzaCorrente;
	
	public void setCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente=stanzaCorrente;
	}
	public Stanza getCorrente() {
		return stanzaCorrente;
	}
	public void setFinale(Stanza stanzaFinale) {
		this.stanzaFinale = stanzaFinale;
	}
	public Stanza getFinale() {
		return stanzaFinale;
	}
	
	public Labirinto() {
		creaStanze();
	}		
		 /**
	     * Crea tutte le stanze e le porte di collegamento
	     */
    private void creaStanze() {
    	
			/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
	    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
	        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
			// il gioco comincia nell'atrio
		stanzaIniziale = atrio;
		stanzaCorrente = stanzaIniziale;
		stanzaFinale = biblioteca;
    }
    

    
}
